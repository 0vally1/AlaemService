
# 报警中心

### 中心中转站 可以短连接查询 也可以ws长连接  client.html是长连接
###  
curl --location --request POST 'http://127.0.0.1:8085/call/phone' \
--header 'Content-Type: application/json' \
--data-raw '{
"phone":"***********"
}'
###

###
curl --location --request POST 'http://127.0.0.1:8085/call/signal' \
--header 'Content-Type: application/json' \
--data-raw '{

}'
###

#  python phone_alarm.py 电话报警服务
##  -p 人员
### python phone_alarm.py -p 'Type.VALLEY' 

