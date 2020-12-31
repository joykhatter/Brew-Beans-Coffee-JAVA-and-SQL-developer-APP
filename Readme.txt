This project is developed in netbeans
To run this project:
1- Create Database tables(BB_create and BB_Database_Populate sql file) in sql developer
2- Copy and Paste the script from "StoreProceduresAndFuntion.txt" file into sql developer and run the script (It will create all the store procedures and functions required in the tasks)
3- Open Project in netbeans and add "ojdbc6.jar" file in your project
4- in src/com/connection("com.connection" package in netbeans file explorer) open "DBConnection.java" file and add your username and password to access your oracle database
5- in src/com/main("com.main" package in netbeans file explorer) contains "Main.java" file where you can run this project


Task 1:
ProductFrame(GUI)
UPDATE_BB_PRODUCT(Store Procedure)

Task 2:
AddProductFrame(GUI)
PROD_ADD_SP(Store Procedure)

Task 3:
TaxCalculationFrame(GUI)
TAX_COST_SP(Store Procedure)

Task 4:
BasketStatusFrame(GUI)
STATUS_SHIP_SP(Store Procedure)

Task 5:
BasketFrame(GUI)
BASKET_ADD_SP(Store Procedure)

Task 6:
CheckSaleProducts(GUI)
CK_SALE_SF(Function)

Report 1:
Report1Frame(GUI)
PLSQL Block executed in code(com/daoimpl/BasketItemDaoImpl.java "checkItemStock()" Method)

Report 2:
Report2Frame(GUI)
TOT_PURCH_SF(Function)