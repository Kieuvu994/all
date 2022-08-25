/*jshint esversion: 6 */

const fs = require('fs');
const http = require('http');
const urlm = require('url');
var socketIo = require("socket.io");        // web socket external module


const nicklist = [];
const rooms = [];

const server = http.createServer(function(request, response){
    // console.log(request.method+'--> '+request.url);
    const parsedUrl = urlm.parse(request.url, true);
    let url = parsedUrl.pathname;
    let query = parsedUrl.query;

    if(url == '/'){
        fs.createReadStream('./index.html','utf8').pipe(response);
    }else if(url.endsWith('.ico')){
        response.writeHead(200, {'Content-Type': 'image/x-ico'});
        fs.createReadStream('.'+url,'utf8').pipe(response);
    }else if(url.endsWith('.html')){
        response.writeHead(200, {'Content-Type': 'text/html'});
        fs.createReadStream('.'+url,'utf8').pipe(response);
    }else if(url.endsWith('.js')){
        response.writeHead(200, {'Content-Type': 'text/javascript'});
        fs.createReadStream('.'+url,'utf8').pipe(response);
    }else if(url.endsWith('.css')){
        response.writeHead(200, {'Content-Type': 'text/css'});
        fs.createReadStream('.'+url,'utf8').pipe(response);
    }else if(url == '/enter'){
        // 채팅방 객체 조회
        // let uRoom = null;
        // rooms.forEach(room => {
        //     if( room.roomName == query.roomname){
        //         uRoom = room;
        //         return;
        //     }
        // });
        // if( uRoom == null){
        //     console.log('have no room :', query.roomname);
        //     response.writeHead(302, {'Location': '/'});
        //     response.end();
        //     return;    
        // }
        // 접속자 브라우저에 쿠키 생성
        let cookies = [];
        cookies.push(encodeURIComponent('nickname') + '=' + encodeURIComponent(query.nickname));
        cookies.push(encodeURIComponent('roomname') + '=' + encodeURIComponent(query.roomname));

        response.writeHead(302, {'Location': '/flex-room.html','Set-Cookie': cookies});
        response.end();
        // const data = fs.readFileSync('./flex-room.html','utf8');
        // response.writeHead(200, {'Content-Type': 'text/html','Set-Cookie': cookies});
        // response.end(data);

        // 접속자 대화명 목록 저장
        // uRoom.nickList.push(query.nickname);

        // 접속자 업데이트 전송
        // uRoom.room.emit('updateMember', uRoom.nickList);

    }else if(url == '/api/nicklist'){
        // room 선택
        if( query != null ){
            let nicklist;
            rooms.forEach(room => {
                if( room.roomName == query.roomname){
                    nicklist = room.nickList;
                    return;
                }
            });
                
            // 현재 접속자들의 대화명 목록을 응답
            response.writeHead(200, {'Content-Type': 'application/json'});
            let data = JSON.stringify({nicklist:nicklist});
            console.log(data);
            response.end(data);
        }
    }else if(url == '/api/out'){
        rooms.forEach(room => {
            if( room.roomNo == Number(query.roomname)){
                const idx = room.nickList.indexOf(query.nickname);
                delete room.nickList[idx];
                return;
            }
        });
    }
});

// 생성된 http server 에 socket server 를 연동
//  URL 로 구분되는 독립적인 그룹(namespace)을 생성하고 그 내에서 다시 개별, 소단위(room)로 구분하여 연결 가능
//  / 는 기본 namespace 로 동작
const io = socketIo(server);    // socket.io v3.x 이상에서는 .listen()을 사용하지 않음
// default namespace
io.on('connection', videochat);
io.on('disconnection', function(){
});

// namespace 별 socket 구분
const ns1 = io.of('/ns1');
ns1.on('connection', function(socket){});
ns1.on('disconnection', function(){});

//  namespace, room 모두 동일한 program 이 실행되므로 함수로 분리 후 callback 
function videochat(socket){
    console.log('connected ', socket.id);

    socket.on('disconnection', function(){
        console.log('Socket-> disconnected client');
    });
    
    socket.on('sendMessage', function(data){
        io.sockets.in(data.room).emit('updateMessage', data);
    });
    socket.on('message',message=>{
        log('Client said : ' ,message);
        socket.broadcast.emit('message',message);
    });
    /**
     * #룸 가입, 탈퇴
     * socket.join('room'); 
     * socket.leave('room'); 
     * #나를 제외한 룸 내 모든이에게 메세지 보내기 
     * socket.broadcast.to('room').emit('event', {}); 
     * # 특정 소켓 사용자에게 메세지 보내기 
     * io.sockets(socket_id).emit('event', {}); 
     * # 룸내 전체 사용자(나를 포함) 메세지 보내기 
     * io.sockets.in('room').emit('event_name', {}) 
     * # 룸전체 목록 
     * io.sockets.adapter.rooms : Map
     * # 클라이언트가 가입한 룸 목록 
     * io.sockets.get(socket.id).apdater 
     * # 룸에 있는 모든 클라이언트 목록 
     * io.sockets.clients('roomid') // 0.9.17 에서는 에러 == io.sockets.manager.rooms['/roomid']
     */
    socket.on('enter room', room => {
        socket.join(room);
        let clientsInRoom = io.sockets.adapter.rooms[room];
        console.log(clientsInRoom);
        // let numClients = clientsInRoom ? Object.keys(clientsInRoom.sockets).length : 0;
        let numClients = io.sockets.adapter.rooms.get(room).size;
        log('Room ' + room + ' now has ' + numClients + ' client(s)');
        socket.emit('created', room, socket.id);
        socket.broadcast.to(room).emit('enter user', socket.id);
        // io.sockets.in(room).emit('enter user', socket.id);
        
    });

    // inner function
    function log() {
        let array = ['Message from server:'];
        array.push.apply(array,arguments);
        socket.emit('log',array);
    }

}

// room1.on('disconnection', function(arg){
//     console.log('Socket-> disconnected client');
// });
// const room2 = io.of('/ROOM-02');
// room2.on('connection', function(socket){
//     console.log('Socket#Room2-> connected client');
//     socket.on('sendMessage', function(data){
//         console.log(data);
//         room2.emit('updateMessage', data);
//     });
// });
// room2.on('disconnection', function(arg){
//     console.log('Socket-> disconnected client');
// });
// const room3 = io.of('/ROOM-03');
// room3.on('connection', function(socket){
//     console.log('Socket#Room3-> connected client');
//     socket.on('sendMessage', function(data){
//         console.log(data);
//         room3.emit('updateMessage', data);
//     });
// });
// room3.on('disconnection', function(arg){
//     console.log('Socket-> disconnected client');
// });
// // server 가 시작 시 rooms 초기화
// rooms.push({room: room1, roomNo: 1, roomName:'ROOM-01', nickList:[]});// 0 index of array
// rooms.push({room: room2, roomNo: 2, roomName:'ROOM-02', nickList:[]});// 1 index of array
// rooms.push({room: room3, roomNo: 3, roomName:'ROOM-03', nickList:[]});// 2 index of array


// 서버 시작
server.listen(3000);
console.log('start node server at http://localhost:3000');
