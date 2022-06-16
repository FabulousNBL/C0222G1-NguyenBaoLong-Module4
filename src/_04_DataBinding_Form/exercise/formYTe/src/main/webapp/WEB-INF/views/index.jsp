<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 16/06/2022
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/dbc3483aca.js" crossorigin="anonymous"></script>
  </head>
  <body>
  <form:form modelAttribute="medical" action="/submit" method="post">
<center>
  <h1>TỜ KHAI BÁO Y TẾ</h1>
  <br>
  <h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/ CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHONG CHỐNG DỊCH BỆNH KHI CẦN THIẾT</h3>
  <br>
  <h5 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h5>
</center>

  <p>Họ tên (ghi chữ IN HOA) <span>(*)</span></p>
<br>
  <form:input path="name"></form:input>
<br>
<br>
  <div style="display: flex ; align-items: center; justify-content: space-between" >

      <div style="width: 33%">
        <p>Năm sinh <span>(*)</span></p>
        <form:select path="age" items="${age}"></form:select>
      </div>
      <div style="width: 33%">
        <p>Giới tính <span>(*)</span></p>
        <form:select path="gender" items="${gender}"></form:select>
      </div>
      <div style="width: 33%">
        <p>Quốc tịch <span>(*)</span></p>
        <form:select path="nation" items="${nations}"></form:select>
      </div>
    </div>
  </div>

    <p>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span>(*)</span></p>
    <form:input path="identity"></form:input>

    <p>Thông tin đi lại <span>(*)</span></p>
    <form:radiobutton path="infoTravel" value="Tàu bay"></form:radiobutton>Tàu bay
    <form:radiobutton path="infoTravel" value="Tàu thuyền"></form:radiobutton>Tàu thuyền
    <form:radiobutton path="infoTravel" value="Ô tô"></form:radiobutton>Ô tô
    <form:radiobutton path="infoTravel" value="Khác (Ghi rõ)"></form:radiobutton>Khác (Ghi rõ)

    <div style="display: flex ; align-items: center; justify-content: space-between">

        <div style="width: 49%">
          <p>Số hiệu phương tiện</p>
          <form:input path="vehicleNumber" style="width: 49%"></form:input>
        </div>
        <div style="width: 49%">
          <p>Số ghế</p>
          <form:input path="chairNumber" style="width: 49%"></form:input>
        </div>
      </div>
    </div>

    <div style="display: flex ; align-items: center; justify-content: space-between">

        <div class="w-50">
          <p>Start day</p>
          <form:input type="date" path="startDay" style="width: 100%"/>

        </div>

        <div class="w-50">
          <p>End day</p>
          <form:input type="date" path="endDay" style="width: 100%"/>

        </div>
      </div>
    </div>

    <button type="submit">Gửi</button>
  </form:form>

  </body>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
          integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
          integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
          crossorigin="anonymous"></script>
  <script src="/bootstrap/js/bootstrap.min.js"></script>
</html>
