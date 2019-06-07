generator-admin
----------------------

**[http://opensource.afterturn.cn/doc/lemur-gen.html](http://opensource.afterturn.cn/doc/lemur-gen.html)**

**线上环境,支持直接使用,不需本地安装,注册即可使用**

**[http://gen.afterturn.cn](http://gen.afterturn.cn)**

数据类型和平台类型对比表
-----------------------
|数据库|数据库类型|java.sql.Types|输出类型|
|----|----|----|----|
|Oracle|blob|blob|byte[]|
| |char|char|String|
| |clob|clob|String|
| |date|date|Date|
| |number|decimal|BigDecimal|
| |long|longvarchar|String|
| |nclob,nvarchar2|other||
| |smallint|smallint|Integer|
| |timestamp|timestamp|Date|
| |raw|varbinary|byte[]|
| |varchar2|varchar|String|
|Sql server|bigint (2005,2008) |bigint|Integer|
| |timestamp,binary|binary|byte[]|
| |bit|bit|Boolean|
| |char,nchar,unqualified |char|String|
| |datetime|date|Date|
| |money,smallmoney,decimal|decimal|BigDecimal|
| |float (2005,2008)|double|Double|
| |float(2000)|float|Double|
| |int|integer|Integer|
| |image|longvarbinary|byte[]|
| |text,ntext,xml|longvarchar|byte[]|
| |numeric|numeric|BigDecimal|
| |real|real|Float|
| |smallint|smallint|Short|
| |smalldatetime|timestamp|Date|
| |tinyint|tinyint|byte|
| |varbinary|varbinay|byte[]|
| |nvarchar,varchar|varchar|String|
|DB2|bigint|bigint|Long|
| |blob|blob|byte[]|
| |character,graphic|char|String|
| |clob|clob|String|
| |date|date|Date|
| |decimal|decimal|BigDecimal|
| |double|double|Double|
| |integer|integer|Integer|
| |longvargraphic,longvarchar|longvarchar|byte[]|
| |real|real|Long|
| |smallint|smallint|Short|
| |time|time|Date|
| |timestamp|timestamp|Date|
| |vargraphic,varchar|varchar|String|
|MySQL|bigint|bigint|Long|
| |tinyblob|binary|byte[]|
| |int|integer|Integer|
| |bit|bit|Boolean|
| |enum,set,char|char|String|
| |date,year|date|Date|
| |decimal,numeric|decimal|BigDecimal|
| |double,real|double|Double|
| |mediumint,int|integer|Integer|
| |blob,mediumblob,longblob|blob|byte[]|
| |float|real|Float|
| |smallint|smallint|Short|
| |time|time|Date|
| |timestamp,datetime|timestamp|Date|
| |tinyint|tinyint|byte|
| |varbinary,binary|varbinay|byte[]|
| |varchar,tinytext,text|varchar|String|


功能
---------
|功能|子功能|进度|开始时间|版本支持|
|----|----|----|----|----|
|数据库管理| |80%|2017-9-01|1.0|
| | CURD|100%|2017-9-01|1.0|
| | 密码加密| | | |
|表管理| |60%| | |
| |CURD| 100%| | |
| |数据库生成表| 100%| | |
| |SQL生成表[已支持:mysql,db2,oracle]| 50%|2018-01-29| |
| |JSON生成表| | | |
| |XML生成表| | | |
|模板管理| |80%|2017-9-01|1.0|
| | CURD|100%|2017-9-01|1.0|
| |语法高亮|100%|2017-9-01|1.0|
| |历史版本|100%|2018-01-29|1.2|
|模板组管理| |100%|2017-9-01|1.0|
| | CURD|100%|2017-9-01|1.0|
| |分享|80% | | 1.2|
|参数管理| |100%|2017-9-01|1.0|
| | CURD|100%|2017-9-01|1.0|
|代码生成| |30%|2017-9-01|1.0|
| | Mysql|100%|2017-9-01|1.0|
| | Oracle| | | |
| | SqlServer| | | |
| | PostgreSQL| | | |
| | DB2| | | |




启动方法
-----------
    1. 下载代码
    2. 导入gen.sql的SQL
    3.运行 GenApplication
    4.访问 localhost:7080
    5.登录 admin/admin

***使用方法***

    1.在数据库管理,新建数据库连接
    2.模板分组建立自己的模板分组
    3.参数管理建立自己的参数
    4.建立自己的模板
    5.代码生成,选择想要生成的表
