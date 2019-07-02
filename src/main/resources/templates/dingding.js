var IP="localhost";  //测试：94.191.43.232   正式：106.13.24.63
var isDing=false;
var ceShiCode='025525064321734942';

//获取有关钉钉需要的值
function  getDingDing() {
    if(isDing){
        var _this=this;
        $.ajax({
            url:"http://"+IP+":8082/journal/queryEmterpriseMesg",
            type:"GET",
            data:{},
            dataType:"json",
            success:function(res){
                return   _this.getCode(res);
            }
        });

    }else{
        return ceShiCode;
    }



}

//获取临时授权码,
function  getCode(_config) {
    var _this=this;
    dd.ready(function() {
        dd.runtime.permission.requestAuthCode({
            corpId:_config.corpId, // 企业id
            onSuccess: function (info) {
                console.log(info)//临时授权码
                return info.code;
                //_this.getDailyList(info.code);
            },
            onFail : function(err) {
                alert('fail: ' + JSON.stringify(err));
            }
        });
    });
}