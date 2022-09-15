-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 23, 2022 at 08:33 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydbcoffee`
--

-- --------------------------------------------------------

--
-- Table structure for table `categoryz`
--

CREATE TABLE `categoryz` (
  `_id` int(11) NOT NULL,
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `categoryz`
--

INSERT INTO `categoryz` (`_id`, `name`) VALUES
(6, 'Trung thu'),
(7, 'Cà phê'),
(8, 'CloudFee'),
(9, 'Hi-Tea Healthy'),
(10, 'Trà Trái Cây - Trà Sữa'),
(11, 'Thưởng thức tại nhà'),
(12, 'Bánh - Snack');

-- --------------------------------------------------------

--
-- Table structure for table `orderitemz`
--

CREATE TABLE `orderitemz` (
  `_id` int(11) NOT NULL,
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `qty` int(11) NOT NULL,
  `image` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT 'nodata',
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `size_id` int(11) NOT NULL,
  `topping_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `orderitemz`
--

INSERT INTO `orderitemz` (`_id`, `name`, `price`, `qty`, `image`, `order_id`, `product_id`, `size_id`, `topping_id`) VALUES
(6, 'Cold Brew Sữa Tươi', '45.00', 2, 'cold-brew-sua-tuoi.jpg', 10, 67, 1, 1),
(7, 'Bánh Trung Thu Cà Phê Trứng Muối', '120.00', 2, 'banh-ca-phe.png', 10, 11, 1, 1),
(8, 'Cà Phê Sữa Đá Chai Fresh 250ML', '75.00', 4, 'BottleCFSD.jpg', 10, 55, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `orderz`
--

CREATE TABLE `orderz` (
  `_id` int(11) NOT NULL,
  `createdAt` datetime NOT NULL,
  `deliveredAt` datetime NOT NULL,
  `isDelivered` tinyint(1) NOT NULL,
  `isPaid` tinyint(1) NOT NULL,
  `paidAt` datetime NOT NULL,
  `paymentMethod` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `shippingPrice` decimal(10,2) NOT NULL,
  `taxPrice` decimal(10,2) NOT NULL,
  `totalPrice` decimal(10,2) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `orderz`
--

INSERT INTO `orderz` (`_id`, `createdAt`, `deliveredAt`, `isDelivered`, `isPaid`, `paidAt`, `paymentMethod`, `shippingPrice`, `taxPrice`, `totalPrice`, `user_id`) VALUES
(10, '2022-08-23 12:43:08', '2022-08-23 12:43:08', 1, 1, '2022-08-23 12:43:08', 'PayPal', '35.00', '63.00', '728.00', 3);

-- --------------------------------------------------------

--
-- Table structure for table `productz`
--

CREATE TABLE `productz` (
  `_id` int(11) NOT NULL,
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `brand` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT 'nodata',
  `category_id` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT 'nodata',
  `rating` int(11) DEFAULT 0,
  `numReview` int(11) DEFAULT 0,
  `createdAt` datetime NOT NULL,
  `countInStock` int(11) DEFAULT 0,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `productz`
--

INSERT INTO `productz` (`_id`, `name`, `brand`, `category_id`, `price`, `description`, `image`, `rating`, `numReview`, `createdAt`, `countInStock`, `user_id`) VALUES
(9, 'Bánh Trung Thu Đậu Xanh Trứng Muối', 'nodata', 6, '110.00', 'Bánh thiệt ngon với sự kết hợp truyền thống giữa đậu xanh mềm mịn, ngọt thanh và trứng muối mằn mặn. Càng dễ ghiền khi nhâm nhi bánh cùng trà hay cà phê.', 'banh-dau-xanh.png', 4, 10, '2022-08-17 00:00:00', 12, 3),
(10, 'Bánh Trung Thu Hạt Sen Trứng Muối', 'nodata', 6, '110.00', 'Bộ đôi nhân sen mềm mịn, dẻo thơm đi cùng trứng muối mằn mặn làm nên hương vị khó quên. Càng thêm hấp dẫn khi nhâm nhi bánh cùng trà hay cà phê.', 'banh-hat-sen.png', 1, 13, '2022-08-17 00:00:00', 100, 3),
(11, 'Bánh Trung Thu Cà Phê Trứng Muối', 'nodata', 6, '120.00', 'Nhất định phải thử hương vị Signature, bán chạy suốt 3 năm của The Coffee House. Vị cà phê đậm nhưng không đắng, ngọt nhẹ kết hợp với trứng muối mằn mặn. Nhân đôi độ ngon khi nhâm nhi bánh cùng trà hay cà phê.', 'banh-ca-phe.png', 2, 5, '2022-08-17 00:00:00', 100, 3),
(12, 'Bánh Trung Thu Thập Cẩm Trứng Muối', 'nodata', 6, '130.00', 'Béo ngậy từ hạt bí và hạt dưa, the cay từ vỏ quýt sấy khô, giòn ngọt của mứt bí và mằn mặn của trứng muối tạo nên hương vị truyền thống đặc sắc. Hấp dẫn hơn khi nhâm nhi bánh cùng trà hay cà phê.', 'banh-thap-cam.jpg', 3, 64, '2022-08-17 00:00:00', 100, 3),
(29, 'Bánh Trung Thu Mứt Tắc Hạt Dưa Trứng Muối', 'nodata', 6, '120.00', 'Đừng bỏ lỡ sự kết hợp vừa lạ vừa quen của đậu xanh mềm mịn cùng mứt tắc (quất) cay nhẹ và hạt dưa giòn bùi. Ngon khó cưỡng khi nhâm nhi bánh cùng trà hay cà phê', 'banh-mut-tac.jpg', 5, 21, '2022-08-23 00:00:00', 100, 3),
(30, 'Bánh Trung Thu Gà Quay Trứng Muối', 'nodata', 6, '130.00', 'Vị mặn của chà bông gà hoà cùng vị béo ngậy của các loại hạt, the cay của vỏ quýt khô, giòn ngọt của mứt bí và mằn mặn của trứng muối. Ngon hơn khi ăn một miếng bánh, nhấp thêm ngụm trà hay cà phê.', 'banh-ga-quay.jpg', 0, 35, '2022-08-23 00:00:00', 100, 3),
(31, 'Bánh Trung Thu Thập Cẩm Trứng Muối', 'nodata', 6, '130.00', 'Béo ngậy từ hạt bí và hạt dưa, the cay từ vỏ quýt sấy khô, giòn ngọt của mứt bí và mằn mặn của trứng muối tạo nên hương vị truyền thống đặc sắc. Hấp dẫn hơn khi nhâm nhi bánh cùng trà hay cà phê.', 'banh-thap-cam.jpg', 1, 49, '2022-08-23 00:00:00', 100, 3),
(49, 'Cà Phê Sữa Đá', 'nodata', 7, '29.00', 'Cà phê Đắk Lắk nguyên chất được pha phin truyền thống kết hợp với sữa đặc tạo nên hương vị đậm đà, hài hòa giữa vị ngọt đầu lưỡi và vị đắng thanh thoát nơi hậu vị.', 'ca-phe-sua-da.png', 1, 82, '2022-08-23 00:00:00', 100, 3),
(50, 'Cà Phê Sữa Nóng', 'nodata', 7, '35.00', 'Cà phê được pha phin truyền thống kết hợp với sữa đặc tạo nên hương vị đậm đà, hài hòa giữa vị ngọt đầu lưỡi và vị đắng thanh thoát nơi hậu vị.', 'cfsua-nong.png', 3, 74, '2022-08-23 00:00:00', 100, 3),
(51, 'Bạc Sỉu', 'nodata', 7, '29.00', 'Bạc sỉu chính là \"Ly sữa trắng kèm một chút cà phê\". Thức uống này rất phù hợp những ai vừa muốn trải nghiệm chút vị đắng của cà phê vừa muốn thưởng thức vị ngọt béo ngậy từ sữa.', 'bac-siu.png', 4, 69, '2022-08-23 00:00:00', 2424, 3),
(52, 'Bạc Sỉu Nóng', 'nodata', 7, '35.00', 'Bạc sỉu chính là \"Ly sữa trắng kèm một chút cà phê\". Thức uống này rất phù hợp những ai vừa muốn trải nghiệm chút vị đắng của cà phê vừa muốn thưởng thức vị ngọt béo ngậy từ sữa.', 'bacsiunong.png', 1, 4, '2022-08-23 00:00:00', 724, 3),
(53, 'Cà Phê Đen Đá', 'nodata', 7, '29.00', 'Không ngọt ngào như Bạc sỉu hay Cà phê sữa, Cà phê đen mang trong mình phong vị trầm lắng, thi vị hơn. Người ta thường phải ngồi rất lâu mới cảm nhận được hết hương thơm ngào ngạt, phảng phất mùi cacao và cái đắng mượt mà trôi tuột xuống vòm họng.', 'ca-phe-den-da.png', 3, 2, '2022-08-23 00:00:00', 52, 3),
(54, 'Cà Phê Đen Nóng', 'nodata', 7, '35.00', 'Không ngọt ngào như Bạc sỉu hay Cà phê sữa, Cà phê đen mang trong mình phong vị trầm lắng, thi vị hơn. Người ta thường phải ngồi rất lâu mới cảm nhận được hết hương thơm ngào ngạt, phảng phất mùi cacao và cái đắng mượt mà trôi tuột xuống vòm họng.', 'ca-phe-den-nong.png', 4, 8, '2022-08-23 00:00:00', 757, 3),
(55, 'Cà Phê Sữa Đá Chai Fresh 250ML', 'nodata', 7, '75.00', 'Vẫn là hương vị cà phê sữa đậm đà quen thuộc của The Coffee House nhưng khoác lên mình một chiếc áo mới tiện lợi hơn, tiết kiệm hơn phù hợp với bình thường mới, giúp bạn tận hưởng một ngày dài trọn vẹn. *Sản phẩm dùng ngon nhất trong ngày. *Sản phẩm mặc định mức đường và không đá.', 'BottleCFSD.jpg', 5, 2, '2022-08-23 00:00:00', 21, 3),
(56, 'Caramel Macchiato Đá', 'nodata', 7, '49.00', 'Caramel Macchiato sẽ mang đến một sự ngạc nhiên thú vị khi vị thơm béo của bọt sữa, sữa tươi, vị đắng thanh thoát của cà phê Espresso hảo hạng và vị ngọt đậm của sốt caramel được gói gọn trong một tách cà phê.', 'caramel-macchiato.png', 1, 4, '2022-08-23 00:00:00', 28785, 3),
(57, 'Caramel Macchiato Nóng', 'nodata', 7, '49.00', 'Caramel Macchiato sẽ mang đến một sự ngạc nhiên thú vị khi vị thơm béo của bọt sữa, sữa tươi, vị đắng thanh thoát của cà phê Espresso hảo hạng và vị ngọt đậm của sốt caramel được gói gọn trong một tách cà phê.', 'caramelmacchiatonong.png', 3, 36, '2022-08-23 00:00:00', 8, 3),
(58, 'Latte Đá', 'nodata', 7, '49.00', 'Một sự kết hợp tinh tế giữa vị đắng cà phê Espresso nguyên chất hòa quyện cùng vị sữa nóng ngọt ngào, bên trên là một lớp kem mỏng nhẹ tạo nên một tách cà phê hoàn hảo về hương vị lẫn nhãn quan.', 'latte-da.png', 2, 96, '2022-08-23 00:00:00', 5, 3),
(59, 'Latte Nóng', 'nodata', 7, '49.00', 'Một sự kết hợp tinh tế giữa vị đắng cà phê Espresso nguyên chất hòa quyện cùng vị sữa nóng ngọt ngào, bên trên là một lớp kem mỏng nhẹ tạo nên một tách cà phê hoàn hảo về hương vị lẫn nhãn quan.', 'latte.png', 1, 4, '2022-08-23 00:00:00', 858, 3),
(60, 'Americano Đá', 'nodata', 7, '39.00', 'Americano được pha chế bằng cách pha thêm nước với tỷ lệ nhất định vào tách cà phê Espresso, từ đó mang lại hương vị nhẹ nhàng và giữ trọn được mùi hương cà phê đặc trưng.', 'classic-cold-brew.jpg', 2, 5, '2022-08-23 00:00:00', 0, 3),
(61, 'Americano Nóng', 'nodata', 7, '39.00', 'Americano được pha chế bằng cách pha thêm nước với tỷ lệ nhất định vào tách cà phê Espresso, từ đó mang lại hương vị nhẹ nhàng và giữ trọn được mùi hương cà phê đặc trưng.', 'arme-nong.jpg', 3, 5, '2022-08-23 00:00:00', 8, 3),
(62, 'Cappuccino Đá', 'nodata', 7, '49.00', 'Capuchino là thức uống hòa quyện giữa hương thơm của sữa, vị béo của bọt kem cùng vị đậm đà từ cà phê Espresso. Tất cả tạo nên một hương vị đặc biệt, một chút nhẹ nhàng, trầm lắng và tinh tế.', 'capu-da.png', 5, 8, '2022-08-23 00:00:00', 0, 3),
(63, 'Cappuccino Nóng', 'nodata', 7, '49.00', 'Capuchino là thức uống hòa quyện giữa hương thơm của sữa, vị béo của bọt kem cùng vị đậm đà từ cà phê Espresso. Tất cả tạo nên một hương vị đặc biệt, một chút nhẹ nhàng, trầm lắng và tinh tế.', 'cappuccino.png', 4, 9, '2022-08-23 00:00:00', 2, 3),
(64, 'Espresso Đá', 'nodata', 7, '45.00', 'Một tách Espresso nguyên bản được bắt đầu bởi những hạt Arabica chất lượng, phối trộn với tỉ lệ cân đối hạt Robusta, cho ra vị ngọt caramel, vị chua dịu và sánh đặc.', 'cfdenda-espressoDa.jpg', 3, 7, '2022-08-23 00:00:00', 2, 3),
(65, 'Espresso Nóng', 'nodata', 7, '39.00', 'Một tách Espresso nguyên bản được bắt đầu bởi những hạt Arabica chất lượng, phối trộn với tỉ lệ cân đối hạt Robusta, cho ra vị ngọt caramel, vị chua dịu và sánh đặc.', 'espressoNong.jpg', 1, 5, '2022-08-23 00:00:00', 5, 3),
(66, 'Cold Brew Truyền Thống', 'nodata', 7, '45.00', 'Tại The Coffee House, Cold Brew được ủ và phục vụ mỗi ngày từ 100% hạt Arabica Cầu Đất với hương gỗ thông, hạt dẻ, nốt sô-cô-la đặc trưng, thoang thoảng hương khói nhẹ giúp Cold Brew giữ nguyên vị tươi mới.', 'classic-cold-brew.jpg', 2, 10, '2022-08-23 00:00:00', 36, 3),
(67, 'Cold Brew Sữa Tươi', 'nodata', 7, '45.00', 'Thanh mát và cân bằng với hương vị cà phê nguyên bản 100% Arabica Cầu Đất cùng sữa tươi thơm béo cho từng ngụm tròn vị, hấp dẫn.', 'cold-brew-sua-tuoi.jpg', 4, 16, '2022-08-23 00:00:00', 53, 3),
(71, 'CloudFee Trứng Hà Nội', 'nodata', 8, '45.00', 'Lấy cảm hứng từ cà phê trứng đặc sản thủ đô, CloudFee Trứng Hà Nội khiến bạn dễ ghiền ngay từ ngụm đầu tiên, bởi chút thơm béo từ kem trứng, ngọt của sữa, hài hòa cùng vị đắng nhẹ từ ca cao và cà phê.', 'trung-ha-noi.png', 5, 5, '2022-08-23 00:00:00', 431, 3),
(72, 'CloudFee Sữa Đá Sài Gòn', 'nodata', 8, '45.00', 'Hương vị cà phê nguyên chất, kết hợp cùng sữa đặc và kem sữa tạo nên thức uống mới mẻ. CloudFee Sữa Đá Sài Gòn êm mượt, ngậy nhưng không ngấy, vừa ngòn ngọt vừa đăng đắng, hấp dẫn đến giọt cuối cùng.', 'sua-da-sai-gon.png', 2, 14, '2022-08-23 00:00:00', 5462, 3),
(73, 'CloudFee Muối Đà Nẵng', 'nodata', 8, '45.00', 'Một chút mằn mặn của muối, quyện cùng vị đậm đà từ cà phê, beo béo của sữa đặc và kem sữa, CloudFee Muối Đà Nẵng chỉ cần nhấp một ngụm là nhớ hoài.', 'muoi-da-nang.png', 0, 30, '2022-08-23 00:00:00', 5825, 3),
(74, 'CloudFee Creamy Hạnh Nhân Nướng', 'nodata', 8, '39.00', 'Vị đắng của cà phê được dung hòa bởi sự ngọt ngào từ kem sữa, điểm tô chút nhẹ nhàng cùng lớp foam trắng bồng bềnh, quyện lẫn vị hạnh nhân nướng bùi bùi vui miệng, thêm thạch cà phê giòn ngon khó cưỡng. Đây là thức uống đúng gu giúp bạn khởi đầu ngày mới với tinh thần phơi phới.', 'caramel-cm.jpg', 1, 65, '2022-08-23 00:00:00', 55, 3),
(75, 'CloudFee Creme Brulee Hạnh Nhân Nướng', 'nodata', 8, '49.00', 'CloudFee Creme Brulee Hạnh Nhân Nướng đánh thức vị giác bằng lớp kem trứng Creme Brulee ngọt ngào lẫn chút đắng nhẹ từ cà phê Espresso Ý. Nhấp từng ngụm để cảm nhận trọn vẹn vị hạnh nhân nướng thơm bùi cùng topping thạch cà phê dai giòn cực cuốn.', 'cbf-caramel.jpg', 2, 10, '2022-08-23 00:00:00', 4, 3),
(76, 'Hi-Tea Xoài Bling Bling', 'nodata', 9, '65.00', 'Xoài chín mọng, vàng ươm có vị ngọt thanh kết hợp cùng trà hoa Hibiscus chua nhẹ, sẽ khiến bạn khó lòng quên được thức uống mát rượi này. Đặc biệt, đừng ngại ngần “khuấy để thấy trăng” để bất ngờ với hiệu ứng lấp lánh, được làm từ bột nhũ vàng dùng trong thực phẩm.', 'hi-tea-xoai.jpg', 3, 25, '2022-08-23 00:00:00', 21, 3),
(77, 'Hi-Tea Phúc Bồn Tử Bling Bling', 'nodata', 9, '65.00', 'Nền trà Hibiscus thanh mát, quyện vị chua chua ngọt ngọt của phúc bồn tử 100% tự nhiên cùng quýt mọng nước mang đến cảm giác sảng khoái tức thì. Đặc biệt, bạn đừng bỏ lỡ trải nghiệm “khuấy để thấy trăng” với hiệu ứng bling bling lạ mắt, được làm từ bột nhũ vàng dùng trong thực phẩm.', 'hi-tea-pbt.jpg', 4, 0, '2022-08-23 00:00:00', 54, 3),
(82, 'Hi-Tea Dâu Tây Mận Muối Aloe Vera', 'nodata', 9, '49.00', 'Sự kết hợp độc đáo giữa 3 sắc thái hương vị khác nhau: trà hoa Hibiscus chua thanh, Mận muối mặn mặn và Dâu tây tươi Đà Lạt cô đặc ngọt dịu. Ngoài ra, topping Aloe Vera tươi mát, ngon ngất ngây, đẹp đắm say, hứa hẹn sẽ khuấy đảo hè này.', 'dau-man-muoi-aloe-vera.png', 5, 6, '2022-08-23 00:00:00', 52, 3),
(83, 'Hi-Tea Đá Tuyết Xoài Đào', 'nodata', 9, '55.00', 'Những miếng đào vàng ươm kết hợp với đá tuyết vị xoài mát lành, cùng nền trà hoa Hibiscus chua dịu đem đến cảm giác lạ miệng, hấp dẫn đến tận ngụm cuối cùng.', 'da-tuyet-dao.png', 1, 0, '2022-08-23 00:00:00', 32, 3),
(84, 'Hi-Tea Đá Tuyết Yuzu Vải', 'nodata', 9, '55.00', 'Chút ngọt ngào của Vải, mix cùng vị chua thanh tao từ trà hoa Hibiscus, mang đến cho bạn thức uống đúng chuẩn vừa ngon, vừa healthy.', 'da-tuyet-vai.png', 1, 1, '2022-08-23 00:00:00', 13, 3),
(85, 'Hi-Tea Đào', 'nodata', 9, '49.00', 'Sự kết hợp ăn ý giữa Đào cùng trà hoa Hibiscus, tạo nên tổng thể hài hoà dễ gây “thương nhớ” cho team thích món thanh mát, có vị chua nhẹ.', 'hi-tea-dao.png', 2, 0, '2022-08-23 00:00:00', 5, 3),
(86, 'Trà Đào Cam Sả - Đá', 'nodata', 10, '49.00', 'Vị thanh ngọt của đào, vị chua dịu của Cam Vàng nguyên vỏ, vị chát của trà đen tươi được ủ mới mỗi 4 tiếng, cùng hương thơm nồng đặc trưng của sả chính là điểm sáng làm nên sức hấp dẫn của thức uống này.', 'tra-dao-cam-xa.png', 3, 4, '2022-08-23 00:00:00', 62, 3),
(87, 'Trà Đào Cam Sả - Nóng', 'nodata', 10, '55.00', 'Vị thanh ngọt của đào, vị chua dịu của Cam Vàng nguyên vỏ, vị chát của trà đen tươi được ủ mới mỗi 4 tiếng, cùng hương thơm nồng đặc trưng của sả chính là điểm sáng làm nên sức hấp dẫn của thức uống này.', 'tdcs-nong.jpg', 5, 5, '2022-08-23 00:00:00', 43, 3),
(88, 'Trà Hạt Sen - Nóng', 'nodata', 10, '55.00', 'Nền trà oolong hảo hạng kết hợp cùng hạt sen tươi, bùi bùi thơm ngon. Trà hạt sen là thức uống thanh mát, nhẹ nhàng phù hợp cho cả buổi sáng và chiều tối.', 'tra-sen-nong.jpg', 1, 5, '2022-08-23 00:00:00', 51, 3),
(89, 'Trà Hạt Sen - Đá', 'nodata', 10, '49.00', 'Nền trà oolong hảo hạng kết hợp cùng hạt sen tươi, bùi bùi và lớp foam cheese béo ngậy. Trà hạt sen là thức uống thanh mát, nhẹ nhàng phù hợp cho cả buổi sáng và chiều tối.', 'tra-nhan-da.jpg', 1, 1, '2022-08-23 00:00:00', 24, 3),
(90, 'Trà Long Nhãn Hạt Chia', 'nodata', 10, '55.00', 'Vị nhãn ngọt, tươi mát đặc trưng hoà quyện tinh tế cùng vị trà oolong hảo hạng và hạt chia mang đến cho bạn một thức uống không chỉ thơm ngon mà còn bổ dưỡng.', 'nhan-hat-chia--nong.jpg', 5, 5, '2022-08-23 00:00:00', 312, 3),
(91, 'Trà Đào Cam Sả Chai Fresh 500ML', 'nodata', 10, '105.00', 'Với phiên bản chai fresh 500ml, thức uống \"best seller\" đỉnh cao mang một diện mạo tươi mới, tiện lợi, phù hợp với bình thường mới và vẫn giữ nguyên vị thanh ngọt của đào, vị chua dịu của cam vàng nguyên vỏ và vị trà đen thơm lừng ly Trà đào cam sả nguyên bản. *Sản phẩm dùng ngon nhất trong ngày. *Sản phẩm mặc định mức đường và không đá.', 'Bottle_TraDao.jpg', 3, 12, '2022-08-23 00:00:00', 583, 3),
(92, 'Trà Đen Macchiato', 'nodata', 10, '55.00', 'Trà đen được ủ mới mỗi ngày, giữ nguyên được vị chát mạnh mẽ đặc trưng của lá trà, phủ bên trên là lớp Macchiato \"homemade\" bồng bềnh quyến rũ vị phô mai mặn mặn mà béo béo.', 'tra-den-matchiato.jpg', 2, 20, '2022-08-23 00:00:00', 63, 3),
(93, 'Hồng Trà Sữa Trân Châu', 'nodata', 10, '55.00', 'Thêm chút ngọt ngào cho ngày mới với hồng trà nguyên lá, sữa thơm ngậy được cân chỉnh với tỉ lệ hoàn hảo, cùng trân châu trắng dai giòn có sẵn để bạn tận hưởng từng ngụm trà sữa ngọt ngào thơm ngậy thiệt đã.', 'hong-tra-sua-tran-chau.jpg', 5, 31, '2022-08-23 00:00:00', 54, 3),
(94, 'Hồng Trà Sữa Nóng', 'nodata', 10, '55.00', 'Từng ngụm trà chuẩn gu ấm áp, đậm đà beo béo bởi lớp sữa tươi chân ái hoà quyện. Trà đen nguyên lá âm ấm dịu nhẹ, quyện cùng lớp sữa thơm béo khó lẫn - hương vị ấm áp chuẩn gu trà, cho từng ngụm nhẹ nhàng, ngọt dịu lưu luyến mãi nơi cuống họng.', 'hong-tra-sua-nong.jpg', 4, 20, '2022-08-23 00:00:00', 213, 3),
(95, 'Trà sữa Oolong Nướng Trân Châu', 'nodata', 10, '55.00', 'Hương vị chân ái đúng gu đậm đà với trà oolong được “sao” (nướng) lâu hơn cho hương vị đậm đà, hòa quyện với sữa thơm béo mang đến cảm giác mát lạnh, lưu luyến vị trà sữa đậm đà nơi vòm họng.', 'oolongda.jpg', 3, 14, '2022-08-23 00:00:00', 235, 3),
(96, 'Trà Sữa Oolong Nướng Nóng', 'nodata', 10, '55.00', 'Đậm đà chuẩn gu và ấm nóng - bởi lớp trà oolong nướng đậm vị hoà cùng lớp sữa thơm béo. Hương vị chân ái đúng gu đậm đà - trà oolong được \"sao\" (nướng) lâu hơn cho vị đậm đà, hoà quyện với sữa thơm ngậy. Cho từng ngụm ấm áp, lưu luyến vị trà sữa đậm đà mãi nơi cuống họng.', 'oolong-nuong-nong.jpg', 2, 19, '2022-08-23 00:00:00', 21, 3),
(97, 'Trà Sữa Mắc Ca Trân Châu', 'nodata', 10, '55.00', 'Mỗi ngày với The Coffee House sẽ là điều tươi mới hơn với sữa hạt mắc ca thơm ngon, bổ dưỡng quyện cùng nền trà oolong cho vị cân bằng, ngọt dịu đi kèm cùng Trân châu trắng giòn dai mang lại cảm giác “đã” trong từng ngụm trà sữa.', 'tra-sua-mac-ca.jpg', 1, 16, '2022-08-23 00:00:00', 425, 3),
(98, 'Hồng Trà Latte Macchiato', 'nodata', 10, '55.00', 'Sự kết hợp hoàn hảo bởi hồng trà dịu nhẹ và sữa tươi, nhấn nhá thêm lớp macchiato trứ danh của The Coffee House mang đến cho bạn hương vị trà sữa đúng gu tinh tế và healthy.', 'hong-tra-latte.jpg', 4, 13, '2022-08-23 00:00:00', 6315, 3),
(99, 'Trà Sữa Oolong Nướng Trân Châu Chai Fresh 500ML', 'nodata', 10, '95.00', 'Phiên bản chai fresh 500ml mới, The Coffee House tin rằng với diện mạo mới: tiện lợi và phù hợp với bình thường mới này, các tín đồ trà sữa sẽ được thưởng thức hương vị đậm đà, hòa quyện với sữa thơm béo mang đến cảm giác mát lạnh ở bất cứ nơi đâu. *Sản phẩm dùng ngon nhất trong ngày. *Sản phẩm mặc định mức đường và không đá.', 'Bottle_oolong.jpg', 1, 10, '2022-08-23 00:00:00', 2143, 3),
(100, 'Cà Phê Sữa Đá Hòa Tan (10 gói x 22g)', 'nodata', 11, '44.00', 'Thật dễ dàng để bắt đầu ngày mới với tách cà phê sữa đá sóng sánh, thơm ngon như cà phê pha phin. Vị đắng thanh của cà phê hoà quyện với vị ngọt béo của sữa, giúp bạn luôn tỉnh táo và hứng khởi cho ngày làm việc thật hiệu quả.', 'cpsd-3in1.jpg', 3, 11, '2022-08-23 00:00:00', 552, 3),
(101, 'Cà Phê Hoà Tan Đậm Vị Việt (18 gói x 16 gam)', 'nodata', 11, '48.00', 'Bắt đầu ngày mới với tách cà phê sữa “Đậm vị Việt” mạnh mẽ sẽ giúp bạn luôn tỉnh táo và hứng khởi cho ngày làm việc thật hiệu quả.', 'ca-phe-sua-da-hoa-tan-dam-vi-viet.jpg', 2, 1, '2022-08-23 00:00:00', 5612, 3),
(102, 'Cà Phê Rang Xay Original 1 250g', 'nodata', 11, '59.00', 'Cà phê Original 1 của The Coffee House với thành phần chính cà phê Robusta Đắk Lắk, vùng trồng cà phê nổi tiếng nhất Việt Nam. Bằng cách áp dụng kỹ thuật rang xay hiện đại, Cà phê Original 1 mang đến trải nghiệm tuyệt vời khi uống cà phê tại nhà với hương vị đậm đà truyền thống hợp khẩu vị của giới trẻ sành cà phê.', 'ca-phe-rang-xay-original-1-250gr.jpg', 0, 43, '2022-08-23 00:00:00', 536, 3),
(103, 'Cà Phê Nguyên Hạt Arabica TCH (200gr)', 'nodata', 11, '98.00', 'The Coffee House gửi bạn hương vị cà phê từ 100% hạt Arabica, được chọn lọc kỹ lưỡng tại vùng Cầu Đất, với độ cao 1650m. Với vị đắng nhẹ, hậu vị chua thanh, ngọt dịu, Cà phê nguyên hạt Arabica từ The Coffee House sẽ giúp bạn tạo ra những tách cà phê cold brew hay hand brew tinh tế yêu thích của riêng mình.', 'Arabica.jpg', 5, 43, '2022-08-23 00:00:00', 252, 3),
(104, 'Thùng 24 Lon Cà Phê Sữa Đá', 'nodata', 11, '330.00', 'Với thiết kế lon cao trẻ trung, hiện đại và tiện lợi, Cà phê sữa đá lon thơm ngon đậm vị của The Coffee House sẽ đồng hành cùng nhịp sống sôi nổi của tuổi trẻ và giúp bạn có được một ngày làm việc đầy hứng khởi.', '24-lon-cpsd.jpg', 1, 0, '2022-08-23 00:00:00', 120, 3),
(105, 'Trà Oolong Túi Lọc Tearoma 20x2G', 'nodata', 11, '28.00', 'Trà Oolong túi lọc với mùi hương dịu nhẹ hoàn toàn từ tự nhiên, vị hậu ngọt, và hương thơm tinh tế. Trà túi lọc Tearoma tiện lợi để sử dụng tại văn phòng, tại nhà,... nhưng vẫn đảm bảo được chất lượng về hương trà tinh tế, vị trà đậm đà.', 'tra-oolong-tui-loc-tearoma-20x2gr.jpg', 3, 5, '2022-08-23 00:00:00', 1012, 3),
(106, 'Trà Lài Túi Lọc Tearoma 20x2G', 'nodata', 11, '28.00', 'Trà túi lọc Tearoma hương lài thơm tinh tế, thanh mát, trên nền trà xanh đậm đà khó quên. Trà túi lọc Tearoma tiện lợi để sử dụng tại văn phòng, tại nhà,.. nhưng vẫn đảm bảo được chất lượng về hương trà tinh tế, vị trà đậm đà.', 'tra-lai-tui-loc-tearoma-20x2gr.jpg', 2, 6, '2022-08-23 00:00:00', 55, 3),
(107, 'Trà Sen Túi Lọc Tearoma 20x2G', 'nodata', 11, '28.00', 'Trà túi lọc Tearoma hương sen tinh tế, thanh mát, trên nền trà xanh đậm đà khó quên. Trà túi lọc Tearoma tiện lợi để sử dụng tại văn phòng, tại nhà, đi du lịch,... nhưng vẫn đảm bảo được chất lượng về hương trà tinh tế, vị trà đậm đà.', 'tra-sen-tui-loc-tearoma-20x2gr.jpg', 4, 9, '2022-08-23 00:00:00', 11, 3),
(108, 'Trà Đào Túi Lọc Tearoma 20x2G', 'nodata', 11, '28.00', 'Trà túi lọc Tearoma hương đào với hương thơm tinh tế và hoàn toàn tự nhiên, cùng nền trà đen đậm vị khó quên. Trà túi lọc Tearoma tiện lợi để sử dụng tại văn phòng, tại nhà,.. nhưng vẫn đảm bảo được chất lượng về hương trà tinh tế, vị trà đậm đà.', 'tra-dao-tui-loc-tearoma-20x2gr.jpg', 5, 7, '2022-08-23 00:00:00', 34, 3),
(109, 'Bánh Mì Que Pate', 'nodata', 12, '12.00', 'Vỏ bánh mì giòn tan, kết hợp với lớp nhân pate béo béo đậm đà sẽ là lựa chọn lý tưởng nhẹ nhàng để lấp đầy chiếc bụng đói , cho 1 bữa sáng - trưa - chiều - tối của bạn thêm phần thú vị.', 'banhmique.jpg', 2, 4, '2022-08-23 00:00:00', 15, 3),
(110, 'Bánh Mì VN Thịt Nguội', 'nodata', 12, '29.00', 'Gói gọn trong ổ bánh mì Việt Nam là từng lớp chả, từng lớp jambon hòa quyện cùng bơ và pate thơm lừng, thêm dưa rau cho bữa sáng đầy năng lượng. *Phần bánh sẽ ngon và đậm đà nhất khi kèm pate. Để đảm bảo hương vị được trọn vẹn, Nhà mong bạn thông cảm vì không thể thay đổi định lượng pate.', 'banh-mi-vietnam.jpg', 1, 6, '2022-08-23 00:00:00', 561, 3),
(111, 'Croissant trứng muối', 'nodata', 12, '35.00', 'Croissant trứng muối thơm lừng, bên ngoài vỏ bánh giòn hấp dẫn bên trong trứng muối vị ngon khó cưỡng.', 'croissant-trung-muoi.jpg', 3, 21, '2022-08-23 00:00:00', 15, 3),
(112, 'Chà Bông Phô Mai', 'nodata', 12, '32.00', 'Chiếc bánh với lớp phô mai vàng sánh mịn bên trong, được bọc ngoài lớp vỏ xốp mềm thơm lừng. Thêm lớp chà bông mằn mặn hấp dẫn bên trên.', 'cha-bong-pho-mai.jpg', 2, 5, '2022-08-23 00:00:00', 11, 3);

-- --------------------------------------------------------

--
-- Table structure for table `reviewz`
--

CREATE TABLE `reviewz` (
  `_id` int(11) NOT NULL,
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `rating` int(11) DEFAULT 0,
  `comment` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT 'nodata',
  `createdAt` datetime NOT NULL,
  `product_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rolez`
--

CREATE TABLE `rolez` (
  `_id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `rolez`
--

INSERT INTO `rolez` (`_id`, `name`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `shippingaddressz`
--

CREATE TABLE `shippingaddressz` (
  `_id` int(11) NOT NULL,
  `address` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `city` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `postalCode` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT 'nodata',
  `country` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `shippingPrice` decimal(10,2) NOT NULL,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `shippingaddressz`
--

INSERT INTO `shippingaddressz` (`_id`, `address`, `city`, `postalCode`, `country`, `shippingPrice`, `order_id`) VALUES
(6, '1975 SAI GON', 'SAI GON CITY', '1975', 'Vietnam', '35.00', 10);

-- --------------------------------------------------------

--
-- Table structure for table `sizez`
--

CREATE TABLE `sizez` (
  `_id` int(11) NOT NULL,
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `sizez`
--

INSERT INTO `sizez` (`_id`, `name`, `price`) VALUES
(1, 'Lớn', 10),
(2, 'Vừa', 6),
(3, 'Nhỏ', 0);

-- --------------------------------------------------------

--
-- Table structure for table `topping`
--

CREATE TABLE `topping` (
  `_id` int(11) NOT NULL,
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `topping`
--

INSERT INTO `topping` (`_id`, `name`, `price`) VALUES
(1, 'Kem Phô Mai Macchiato', 10),
(2, 'Shot Espresso', 10),
(3, 'Trân châu trắng', 10),
(4, 'Sốt Caramel', 10);

-- --------------------------------------------------------

--
-- Table structure for table `userz`
--

CREATE TABLE `userz` (
  `id` int(11) NOT NULL,
  `username` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_joined` datetime NOT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `last_login` datetime DEFAULT '1000-01-01 00:00:00',
  `first_name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT 'USER',
  `image` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT 'nodata'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `userz`
--

INSERT INTO `userz` (`id`, `username`, `email`, `password`, `date_joined`, `is_superuser`, `is_staff`, `is_active`, `last_login`, `first_name`, `last_name`, `role`, `image`) VALUES
(1, 'USER', 'user@user.com', '456789', '2022-08-17 00:00:00', 0, 0, 1, '1000-01-01 00:00:00', 'US', 'ER', 'USER', 'nodata'),
(2, 'ADMIN', 'admin@admin', 'admin', '2022-08-23 00:00:00', 0, 1, 1, '1000-01-01 00:00:00', 'AD', 'MIN', 'ADMIN', 'nodata'),
(3, 'NguyenHHKiet', 'nhoangkiet35@gmail.com', '123456', '2022-08-17 00:00:00', 1, 1, 1, '1000-01-01 00:00:00', 'HoangKiet', 'NguyenHuu', 'ADMIN', 'nodata');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(3, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoryz`
--
ALTER TABLE `categoryz`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `orderitemz`
--
ALTER TABLE `orderitemz`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `orderitem_ibfk_1_idx` (`order_id`),
  ADD KEY `orderitem_ibfk_2_idx` (`product_id`),
  ADD KEY `orderitem_ibfk_3_idx` (`size_id`),
  ADD KEY `orderitem_ibfk_4_idx` (`topping_id`);

--
-- Indexes for table `orderz`
--
ALTER TABLE `orderz`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `order_ibfk_1_idx` (`user_id`);

--
-- Indexes for table `productz`
--
ALTER TABLE `productz`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `product_ibfk_1_idx` (`user_id`),
  ADD KEY `product_ibfk_4_idx` (`category_id`);

--
-- Indexes for table `reviewz`
--
ALTER TABLE `reviewz`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `review_ibfk_1_idx` (`product_id`),
  ADD KEY `review_ibfk_2_idx` (`user_id`);

--
-- Indexes for table `rolez`
--
ALTER TABLE `rolez`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `shippingaddressz`
--
ALTER TABLE `shippingaddressz`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `shippingaddress_ibfk_1_idx` (`order_id`);

--
-- Indexes for table `sizez`
--
ALTER TABLE `sizez`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `topping`
--
ALTER TABLE `topping`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `userz`
--
ALTER TABLE `userz`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `user_role_ibfk_2_idx` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categoryz`
--
ALTER TABLE `categoryz`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `orderitemz`
--
ALTER TABLE `orderitemz`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `orderz`
--
ALTER TABLE `orderz`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `productz`
--
ALTER TABLE `productz`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=113;

--
-- AUTO_INCREMENT for table `reviewz`
--
ALTER TABLE `reviewz`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `rolez`
--
ALTER TABLE `rolez`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `shippingaddressz`
--
ALTER TABLE `shippingaddressz`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `sizez`
--
ALTER TABLE `sizez`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `topping`
--
ALTER TABLE `topping`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `userz`
--
ALTER TABLE `userz`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderitemz`
--
ALTER TABLE `orderitemz`
  ADD CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orderz` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `productz` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `orderitem_ibfk_3` FOREIGN KEY (`size_id`) REFERENCES `sizez` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `orderitem_ibfk_4` FOREIGN KEY (`topping_id`) REFERENCES `topping` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `orderz`
--
ALTER TABLE `orderz`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `userz` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `productz`
--
ALTER TABLE `productz`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `userz` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_ibfk_4` FOREIGN KEY (`category_id`) REFERENCES `categoryz` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reviewz`
--
ALTER TABLE `reviewz`
  ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `productz` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `review_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `userz` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `shippingaddressz`
--
ALTER TABLE `shippingaddressz`
  ADD CONSTRAINT `shippingaddress_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orderz` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `userz` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `rolez` (`_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
