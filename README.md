# usedBikeMarket

---

Used bike database application where a user/admin has to log in to access the features.
Depending on the user role, they have less/more access.

---

Features:

 - trying to access 'Add Bikes', 'update Bikes', 'delete Bikes' prior to login will lead to login page.
 - once logged on, users with role user has access to 'add bikes' and 'update bikes' page.
    - users with both the roles user and admin has access to 'delete Bikes' page on top of the authority of user.
    - the password is encoded and salted to provide extra protection.
 - to add a bike into the system, simply fill out the empty inputs of the form and click add bike
 - to update a bike, click the update button matching the bike you want to change, and a form will appear allowing changes to be made. click update button to submit the changes.
 - to delete a bike, you can just simply click on the delete button beside the bike you'd wish you be deleted

---

This project has been developed in Java using spring boot.
The dependencies used:
 - Spring Data JDBC
 - Thymeleaf
 - Spring Security
 - H2 Database
 - Lombok
 - Spring Web

---

Homepage:

![img](https://github.com/daechi73/usedBikeMarket/blob/main/Homepage.png)

---

LoginPage:

![img](https://github.com/daechi73/usedBikeMarket/blob/main/Loginpage.png)

---

InsertPage:

![img](https://github.com/daechi73/usedBikeMarket/blob/main/insertBIke.png)

---

UpdatePage:

![img](https://github.com/daechi73/usedBikeMarket/blob/main/updateBIke.png)

---

DeletePage:

![img](https://github.com/daechi73/usedBikeMarket/blob/main/deleteBike.png)

---


