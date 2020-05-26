er-Model [Link](https://github.com/hcc444/usermanagement/blob/master/er-model.jpg)

帳號查詢
/users

角色查詢
/roles

清單查詢
/menus

由角色查出所有的帳號
/users/searchByRole/{role name}

由帳號查出所擁有的清單
/users/{user id}/menus

相關查詢結果放在 result 下面 [Link](https://github.com/hcc444/usermanagement/tree/master/result)

所使用設計模式: MVC