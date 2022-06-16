<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 16/06/2022
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Khai báo y tế</h1>
<h3>Họ và tên: ${medical.name}</h3>
<h3>Năm sinh: ${medical.age}</h3>
<h3>Quốc tịch: ${medical.nation}</h3>
<h3>CMND/CCCD: ${medical.identity}</h3>
<h3>Thông tin đi lại: ${medical.infoTravel}</h3>
<h3>Số hiệu phương tiện: ${medical.vehicleNumber}</h3>
<h3>Số ghế: ${medical.chairNumber}</h3>
<h3>Ngày bắt đầu: ${medical.startDay}</h3>
<h3>Ngày kết thúc: ${medical.endDay}</h3>
</body>
</html>
