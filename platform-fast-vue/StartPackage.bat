@ rem ----- 信息 -----
@ rem @filename StartPackage.bat
@ rem @version 1.0
@ rem @description 打包
@ rem @author qye.zheng

@ rem @warning 为了防止中文环境乱码，保存文件的时候，应该保存为ANSI编码格式.
@ rem ################################################################################


@ rem 标题
@ title 打包
@ rem ########## begin  ##########

@ rem 关闭显示命令，使所有命令执行前不显示
@ rem @ echo off
@ rem echo off
@ rem 打开命令显示 @ echo on


set scriptPath=%~dp0
@ rem 进入脚本所在的磁盘
%scriptPath:~0,2%

@ rem 进入脚本所在的目录
cd %scriptPath%

@ rem 执行 node命令，以开发模式运行 
@rem npm run build --prod
cnpm run build

@ rem ----- 变量声明区
:: 设置暂停标识
set stopFlag=false

:: 调用其他 bat 之后，需要重新设置标题，避免被上一个bat程序覆盖


@ rem ----- 程序设计区

:: 成对括号可以把多行要执行的语句包围起来，else 必须和 if 分支的右括号在同一行，否则 else 将被视为新同语句



@ rem pause
if "true"=="%stopFlag%" (pause)
@ rem
:: 退出
@ rem
@ rem 输出提示信息

::
:: 1) 
:: 2)
:: 3)
:: 4)
:: 5)
:: 6)
:: 7)
:: 8)
:: 9)
:: 10)

:: 在程序的末尾，可以根据执行的结果(成功或失败) 给出提示信息，成功可以直接执行exit，而失败
:: 可以执行pause，然后可以通过控制台输出信息来调试、定位问题.
:: 可以在程序中设置一个成功或失败的标志-布尔值，来决定最后程序的执行流程.

@ rem echo
@ rem exit
@ rem ########## end of ##########

@ rem 注释说明: @ rem 注释内容  或者 :: 注释内容
@ rem rem 或两个冒号 后面 都可以写注释
