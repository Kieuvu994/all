# kits-05
- packaging pom

.gitignore 설정 변경 후 git 업데이트 방법  
프로젝트가 진행됨에 따라 .gitignore 에 추가해야 할 것들이 점차 늘어남  
.gitignore 을 정상적으로 추가/수정하였더라도 이미 git에 push된 폴더나 파일들은 삭제되지 않음  

---

$ git rm -r --cached .

$ git add .

$ git commit -m 'git cach removed!'

$ git push origin <brunch 이름>

---
