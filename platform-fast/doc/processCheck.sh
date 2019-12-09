# ----- 信息 -----
# @filename start.sh
# @version 1.0
# @author qianye.zheng
# @description  进程检测脚本，作为定时任务，定期检查目标进程

# 解决远程ssh执行脚本失败问题
source /etc/profile

# 进入脚本所在目录
cd `dirname $0`

# 变量定义
# 进程ID文件
PID_FILE=/data/logs/uni-user-admin/svc.pid
# 命令或脚本
COMMAND=/usr/local/user-uni/back-end/start-user-admin-dev.sh

# 检查进程状态
check_process() {
  if [[ -f "$PID_FILE" ]]; then
    PID=`cat "$PID_FILE" | awk '{print $1}'`
	# 根据进程ID检查该进程是否确实存在
    PID=`ps -aef | grep "$PID" | awk '{print $2}' | grep "$PID"`
    if [[ -z "$PID" ]]; then # -z 字符串长度为0，说明该进程不存在
      # 调用脚本重启
       echo "重启进程"
       sh ${COMMAND}
    else
      # 进程已经在运行
      echo "进程已经在运行，进程ID: ${PID}"
    fi
  else
    echo "进程文件: ${PID_FILE} 不存在"
    PID=''
    PID_FLAG=0
  fi
}

# 执行方法
check_process;

exit 0
