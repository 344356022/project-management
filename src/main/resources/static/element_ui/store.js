
const store=new Vuex.Store({
			state:{
				src:"http://127.0.0.1:8080/default/eos/report/reportUserList.jsp",
				orgTreeOrgCode:"",
				orgTreeOrgName:"",
				viewOrUpdate:"", //定义跳转页面是查看还是修改   修改需要查询数据  1查看2修改
				id:""	//修改跳转页面 传入id属性
			},
			mutations:{
				updateSrc:function(state,para){ //修改tab src
					state.src = para;
				},
				updateTreeData:function(state,para){
					state.orgTreeOrgCode = para.orgcode;
					state.orgTreeOrgName = para.orgname;
				},
				updateViewOrUpdate:function(state,para){
					alert("传入参数"+para.viewOrUpdate);
					state.viewOrUpdate = para.viewOrUpdate;
					alert(state.viewOrUpdate);
					state.id = para.id;
				}
			}
		})