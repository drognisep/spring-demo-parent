# DB INSTALLATION

To install the DB schema, table, and pre-load with test data like what's shown in the course; follow the most applicable procedure below. This guide assumes your mode of connection has already been setup including a MySQL client and local or remote MySQL instance, you have root access for the DB instance, and that you have already cloned this repository. I will refer to the location of the root of spring-demo-parent as `SPRING_DEMO_ROOT`.

### Installation on local DB instance
1. Navigate to `SPRING_DEMO_ROOT/spring-crm-project/src/main/sql` in the command line.
1. Run `mysql -u <your_root_username> -p` and enter your password.
1. Once successfully connected execute `\. install.sql`

### Installation on remote DB instance
1. Navigate to `SPRING_DEMO_ROOT/spring-crm-project/src/main/sql` in the command line.
1. Run `mysql -u <your_root_username> -p -h <remote-host-ip>` and enter your password.
1. Once successfully connected execute `\. install.sql`

Once complete you should see output like the following
```
mysql> \. install.sql
Query OK, 0 rows affected, 1 warning (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Database changed
Query OK, 0 rows affected (0.00 sec)

Query OK, 0 rows affected, 1 warning (0.00 sec)

Query OK, 0 rows affected (0.14 sec)

Query OK, 0 rows affected (0.00 sec)

Query OK, 5 rows affected (0.03 sec)
Records: 5  Duplicates: 0  Warnings: 0

mysql>
```

### Alternative setup to create a new user that can only access the new schema
1. Edit variable values in `install_with_new_user.sql` to your liking
1. Use the correct procedure for your setup above and run `install_with_new_user.sql` instead of `install.sql`
