(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-56519938"],{"25eb":function(t,e,s){var i=s("23e7"),a=s("c20d");i({target:"Number",stat:!0,forced:Number.parseInt!=a},{parseInt:a})},"2bba":function(t,e,s){"use strict";s("df67")},5899:function(t,e){t.exports="\t\n\v\f\r                　\u2028\u2029\ufeff"},"58a8":function(t,e,s){var i=s("1d80"),a=s("5899"),n="["+a+"]",r=RegExp("^"+n+n+"*"),o=RegExp(n+n+"*$"),c=function(t){return function(e){var s=String(i(e));return 1&t&&(s=s.replace(r,"")),2&t&&(s=s.replace(o,"")),s}};t.exports={start:c(1),end:c(2),trim:c(3)}},7156:function(t,e,s){var i=s("861d"),a=s("d2bb");t.exports=function(t,e,s){var n,r;return a&&"function"==typeof(n=e.constructor)&&n!==s&&i(r=n.prototype)&&r!==s.prototype&&a(t,r),t}},a9e3:function(t,e,s){"use strict";var i=s("83ab"),a=s("da84"),n=s("94ca"),r=s("6eeb"),o=s("5135"),c=s("c6b6"),l=s("7156"),d=s("c04e"),u=s("d039"),m=s("7c73"),p=s("241c").f,f=s("06cf").f,b=s("9bf2").f,v=s("58a8").trim,g="Number",_=a[g],h=_.prototype,C=c(m(h))==g,U=function(t){var e,s,i,a,n,r,o,c,l=d(t,!1);if("string"==typeof l&&l.length>2)if(l=v(l),e=l.charCodeAt(0),43===e||45===e){if(s=l.charCodeAt(2),88===s||120===s)return NaN}else if(48===e){switch(l.charCodeAt(1)){case 66:case 98:i=2,a=49;break;case 79:case 111:i=8,a=55;break;default:return+l}for(n=l.slice(2),r=n.length,o=0;o<r;o++)if(c=n.charCodeAt(o),c<48||c>a)return NaN;return parseInt(n,i)}return+l};if(n(g,!_(" 0o1")||!_("0b1")||_("+0x1"))){for(var E,y=function(t){var e=arguments.length<1?0:t,s=this;return s instanceof y&&(C?u((function(){h.valueOf.call(s)})):c(s)!=g)?l(new _(U(e)),s,y):U(e)},x=i?p(_):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger,fromString,range".split(","),w=0;x.length>w;w++)o(_,E=x[w])&&!o(y,E)&&b(y,E,f(_,E));y.prototype=h,h.constructor=y,r(a,g,y)}},c20d:function(t,e,s){var i=s("da84"),a=s("58a8").trim,n=s("5899"),r=i.parseInt,o=/^[+-]?0[Xx]/,c=8!==r(n+"08")||22!==r(n+"0x16");t.exports=c?function(t,e){var s=a(String(t));return r(s,e>>>0||(o.test(s)?16:10))}:r},df67:function(t,e,s){},e001:function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("navbar"),t._v(" Users page "),s("hr"),s("UsersList"),s("hr")],1)},a=[],n=s("5530"),r=s("9d8d"),o=s("2f62"),c=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:" w-75 m-auto"},[t.isModalShow?s("NicModal",{attrs:{"popup-title":t.getModalTitle},on:{closeNicModal:t.modalCLose,confirmBtnAction:t.modalSuccess}},[t.setEdit?t._e():s("UserViewModal",{ref:"userView",attrs:{item:t.item},on:{returnUser:t.returnUser}}),t.setEdit?s("UserAdminModal",{ref:"userAdmin",attrs:{item:t.item},on:{returnUser:t.returnUser}}):t._e(),s("UserInfoTableFooter",{attrs:{slot:"footer","is-admin":"ADMIN"===t.getPosition,"is-edit":t.setEdit},on:{editItem:t.editItem,modalClose:t.modalCLose,saveUser:t.saveUser,deleteUser:t.deleteUser},slot:"footer"})],1):t._e(),"ADMIN"===t.getPosition?s("table",{staticClass:"table table-hover border-top-0  text-left"},[s("tr",[s("td",[s("button",{staticClass:"nic-btn-cansel text-black btn btn-outline-secondary rounded-lg",on:{click:t.createUser}},[t._v(" Создать пользователя ")])])])]):t._e(),s("table",{staticClass:"table table-hover table-bordered text-center"},[t._m(0),s("tbody",t._l(t.getUsers,(function(e){return s("UserInfoTable",{key:e.id,attrs:{user:e},on:{modalShow:function(s){return t.modalShow(e)}}})})),1)]),t.pages>1?s("nic-pagination",{attrs:{page:t.page,pages:t.pages},on:{selectPage:t.setPage}}):t._e()],1)},l=[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("thead",{staticClass:"thead-light"},[s("th",[t._v("Id")]),s("th",[t._v("Учетная запись")]),s("th",[t._v("Имя")]),s("th",[t._v("Должность")]),s("th",[t._v("Дата рождения")])])}],d=(s("96cf"),s("1da1")),u=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("tr",{on:{click:t.userInModal}},[s("td",[t._v(t._s(t.user.id))]),s("td",[t._v(t._s(t.user.login))]),s("td",[t._v(t._s(t.user.firstName))]),s("td",[t._v(t._s(t.user.positionName))]),s("td",[t._v(t._s(t.user.birthday))])])},m=[],p={name:"UserInfoTable",props:{user:{type:Object,default:function(){return{}}}},methods:{userInModal:function(t){this.$emit("modalShow",t)}}},f=p,b=s("2877"),v=Object(b["a"])(f,u,m,!1,null,"ac5ac702",null),g=v.exports,_=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{ref:"ref-popup-wrapper",staticClass:"nic-popup-wrapper"},[s("div",{staticClass:"nic-popup"},[s("div",{staticClass:"nic-popup-header"},[s("span",[t._v(t._s(t.PopupTitle))]),s("span",[s("i",{staticClass:"material-icons",on:{click:t.close}},[t._v("close")])])]),t._t("default"),t._t("footer",[s("span",[s("button",{staticClass:"nic-btn-cansel text-black btn btn-outline-secondary rounded-lg",on:{click:t.close}},[t._v(" Close ")])])])],2)])},h=[],C={name:"nic-modal",props:{PopupTitle:{type:String,default:"Nic Popup Title"},confirmBtnTitle:{type:String,default:"OK"}},methods:{close:function(){this.$emit("closeNicModal")}},mounted:function(){var t=this;document.addEventListener("click",(function(e){e.target===t.$refs["ref-popup-wrapper"]&&t.close()}))}},U=C,E=(s("2bba"),Object(b["a"])(U,_,h,!1,null,"576abacc",null)),y=E.exports,x=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"nic-popup-body container-fluid"},[s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2 "},[t._v("Id:")]),s("b-input",{staticClass:"col-sm text-secondary bg-light border rounded-lg",attrs:{readonly:"",value:t.itemUser.id},model:{value:t.itemUser.id,callback:function(e){t.$set(t.itemUser,"id",e)},expression:"itemUser.id"}})],1),s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2 "},[t._v("Учетная запись:")]),s("b-input",{staticClass:"col-sm text-secondary bg-light border rounded-lg",attrs:{readonly:"",value:t.item.login}})],1),s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2 "},[t._v("Имя:")]),s("b-input",{staticClass:"col-sm text-secondary bg-light border rounded-lg",attrs:{readonly:"",value:t.item.firstName}})],1),s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2"},[t._v("Фамилия:")]),s("b-input",{staticClass:"col-sm text-secondary bg-light border rounded-lg",attrs:{readonly:"",value:t.item.lastName}})],1),s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2"},[t._v("Buro:")]),s("b-input",{staticClass:"col-sm text-secondary bg-light border rounded-lg",attrs:{readonly:"",value:void 0!==t.item.buro?t.item.buro.name:"пусто"}})],1)])},w=[],k={name:"UserViewModal",data:function(){return{itemUser:Object(n["a"])({},this.item)}},props:{item:{type:Object,default:function(){return{}}}},methods:{returnUser:function(){this.$emit("returnUser",this.itemUser)}}},S=k,N=Object(b["a"])(S,x,w,!1,null,"7c722e1f",null),I=N.exports,O=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"nic-popup-body container-fluid"},[s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2 "},[t._v("Id:")]),s("b-input",{staticClass:"col-sm text-secondary bg-light border rounded-lg",attrs:{readonly:"",value:t.item.id}})],1),s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2 "},[t._v("Учетная запись:")]),s("b-input",{staticClass:"col-sm text-secondary bg-light border rounded-lg",attrs:{value:t.itemUser.login},model:{value:t.itemUser.login,callback:function(e){t.$set(t.itemUser,"login",e)},expression:"itemUser.login"}})],1),s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2 "},[t._v("Для пароля:")]),s("b-input",{staticClass:"col-sm text-secondary bg-light border rounded-lg"})],1),s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2 "},[t._v("Имя:")]),s("b-input",{staticClass:"col-sm text-secondary bg-light border rounded-lg",attrs:{value:t.itemUser.firstName},model:{value:t.itemUser.firstName,callback:function(e){t.$set(t.itemUser,"firstName",e)},expression:"itemUser.firstName"}})],1),s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2"},[t._v("Фамилия:")]),s("b-input",{staticClass:"col-sm text-secondary bg-light border rounded-lg",attrs:{value:t.item.lastName}})],1),s("div",{staticClass:"row my-1 mx-2"},[s("div",{staticClass:"col-4 mr-2"},[t._v("Buro:")]),s("select",{staticClass:"col-sm text-secondary bg-light border rounded-lg form-control"},t._l(t.BUROS,(function(e){return s("option",{key:e.id,domProps:{value:e.id}},[t._v(" "+t._s(e.name)+" ")])})),0)])])},A=[],P={name:"UserAdminModal",data:function(){return{itemUser:Object(n["a"])({},this.item)}},props:{item:{type:Object,default:function(){return{}}}},computed:Object(n["a"])({},Object(o["c"])(["BUROS"])),methods:Object(n["a"])(Object(n["a"])({},Object(o["b"])(["GET_ALL_BUROS"])),{},{returnUser:function(){this.$emit("returnUser",this.itemUser)}}),mounted:function(){0===this.BUROS.length&&this.GET_ALL_BUROS()}},T=P,L=Object(b["a"])(T,O,A,!1,null,"7803912e",null),R=L.exports,j=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"row text-center",attrs:{slot:"footer"},slot:"footer"},[!t.isAdmin||t.isEdit||t.isDelete?t._e():s("span",{staticClass:"col-2"},[s("button",{staticClass:"nic-btn-cansel text-black btn btn-outline-danger rounded-lg",on:{click:t.atemptDeleteUser}},[t._v(" Delete ")])]),t.isAdmin&&t.isDelete?s("span",{staticClass:"col-auto"},[s("h5",[t._v(" Подтвердите удаление")])]):t._e(),t.isAdmin&&t.isDelete?s("span",{staticClass:"col-auto"},[s("button",{staticClass:"nic-btn-cansel text-black btn btn-outline-danger rounded-lg",on:{click:t.deleteUser}},[t._v(" Confirm delete ")])]):t._e(),!t.isAdmin||t.isEdit||t.isDelete?t._e():s("span",{staticClass:"col-2"},[s("button",{staticClass:"nic-btn-cansel text-black btn btn-outline-warning rounded-lg",on:{click:t.editItem}},[t._v(" Edit ")])]),t.isAdmin&&t.isEdit?s("span",{staticClass:"col-2"},[s("button",{staticClass:"nic-btn-cansel text-black btn btn-outline-success rounded-lg",on:{click:t.saveUser}},[t._v(" Save ")])]):t._e(),s("span",{staticClass:"col-sm"}),t.isEdit||t.isDelete?t._e():s("span",{staticClass:"col-2"},[s("button",{staticClass:"nic-btn-cansel text-black btn btn-outline-secondary rounded-lg",on:{click:t.modalCLose}},[t._v(" Close ")])]),t.isAdmin&&(t.isEdit||t.isDelete)?s("span",{staticClass:"col-2"},[s("button",{staticClass:"nic-btn-cansel text-black btn btn-outline-secondary rounded-lg",on:{click:t.cancel}},[t._v(" Cancel ")])]):t._e()])},$=[],M={name:"UserInfoTableFooter",data:function(){return{isDelete:!1}},props:{isEdit:{type:Boolean,default:!1},isAdmin:{type:Boolean,default:!1}},methods:{modalCLose:function(){this.$emit("modalClose")},editItem:function(){this.$emit("editItem",!0)},saveUser:function(){this.$emit("saveUser")},atemptDeleteUser:function(){this.isDelete=!0},deleteUser:function(){this.$emit("deleteUser")},cancel:function(){this.$emit("editItem",!1),this.isDelete=!1}}},D=M,B=Object(b["a"])(D,j,$,!1,null,"0409489e",null),G=B.exports,F=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"container-fluid"},[t.pages>1&&t.pages<5?s("div",{staticClass:"row"},[s("div",{staticClass:"col-sm"}),s("div",{staticClass:"col-auto row"},[s("div",{staticClass:"col m-2 btn btn-outline-secondary",on:{click:t.prevPage}},[s("i",{staticClass:"material-icons"},[t._v("keyboard_arrow_left")])]),t._l(t.pages,(function(e,i){return s("div",{key:i,staticClass:"col m-2 btn btn-outline-secondary",on:{click:function(e){return t.selectPage(i)}}},[t._v(" "+t._s(e)+" ")])})),s("div",{staticClass:"col m-2 btn btn-outline-secondary",on:{click:t.nextPage}},[s("i",{staticClass:"material-icons"},[t._v("keyboard_arrow_right")])])],2),s("div",{staticClass:"col-sm"})]):t._e(),t.pages>=5?s("div",{staticClass:"row"},[s("div",{staticClass:"col-sm"}),s("div",{staticClass:"col-auto row"},[s("div",{staticClass:"col m-2 btn btn-outline-secondary",on:{click:t.prevPage}},[s("i",{staticClass:"material-icons"},[t._v("keyboard_arrow_left")])]),t.page>1?s("div",{staticClass:"col m-2 "},[t._v(" ... ")]):t._e(),t.page>0?s("div",{staticClass:"col m-2 btn btn-outline-secondary",on:{click:function(e){return t.selectPage(t.page-1)}}},[t._v(" "+t._s(Number.parseInt(t.currentPage)-1)+" ")]):t._e(),s("input",{staticClass:" col m-2 form-control",domProps:{value:t.currentPage},on:{"!keydown":function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.selectPage2(e)}}}),t.page<t.pages-1?s("div",{staticClass:"col m-2 btn btn-outline-secondary",on:{click:function(e){return t.selectPage(t.page+1)}}},[t._v(" "+t._s(Number.parseInt(t.currentPage)+1)+" ")]):t._e(),t.page<t.pages-2?s("div",{staticClass:"col m-2 "},[t._v(" ... ")]):t._e(),s("div",{staticClass:"col m-2 btn btn-outline-secondary",on:{click:t.nextPage}},[s("i",{staticClass:"material-icons"},[t._v("keyboard_arrow_right")])])]),s("div",{staticClass:"col-sm"})]):t._e()])},V=[],X=(s("a9e3"),s("25eb"),{name:"nic-pagination",props:{page:{type:Number,default:0},pages:{type:Number,default:1}},computed:{currentPage:function(){return this.page+1}},methods:{selectPage2:function(){var t=Number.parseInt(document.querySelector("input").value);this.$emit("selectPage",t)},selectPage:function(t){this.$emit("selectPage",t)},prevPage:function(){var t=this.page-1;t<0&&(t=0),this.$emit("selectPage",t)},nextPage:function(){var t=this.page+1;t>=this.pages-1&&(t=this.pages-1),this.$emit("selectPage",t)}}}),J=X,Y=Object(b["a"])(J,F,V,!1,null,"059d7ec3",null),q=Y.exports,H={name:"UsersList",components:{NicPagination:q,UserInfoTableFooter:G,UserAdminModal:R,UserViewModal:I,UserInfoTable:g,NicModal:y},data:function(){return{isModalShow:!1,item:{},isEdit:!1,page:0,pages:1,isUpdated:!0}},computed:Object(n["a"])(Object(n["a"])({},Object(o["c"])(["getToken","getPosition","USERS"])),{},{getModalTitle:function(){return this.isEdit?"Редактирование данных пользователя: "+this.item.lastName+" "+this.item.firstName:"Информация о пользователе: "+this.item.lastName+" "+this.item.firstName},setEdit:function(){return this.isEdit},getUsers:function(){return this.USERS}}),watch:{USERS:{handler:function(){this.isUpdated||(this.GET_ALL_USERS(),this.isUpdated=!0)},deep:!0}},methods:Object(n["a"])(Object(n["a"])({},Object(o["b"])(["CLEAR_USERS_LIST","GET_ALL_USERS","CREATE_USER","UPDATE_USER","DELETE_USER"])),{},{modalShow:function(t){this.item=t,this.isModalShow=!0,this.isEdit=!1},modalCLose:function(){this.isModalShow=!1},modalSuccess:function(){},editItem:function(t){this.isEdit=t},setPage:function(t){this.page=t},createUser:function(){this.modalShow({}),this.isEdit=!0},saveUser:function(){var t=this;return Object(d["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.$refs.userAdmin.returnUser(),void 0===t.item.id?t.CREATE_USER(t.item):t.UPDATE_USER(t.item),t.modalCLose(),e.next=5,t.updateUsersList();case 5:case"end":return e.stop()}}),e)})))()},deleteUser:function(){var t=this;return Object(d["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.$refs.userView.returnUser(),t.DELETE_USER(t.item),t.modalCLose(),e.next=5,t.updateUsersList();case 5:case"end":return e.stop()}}),e)})))()},returnUser:function(t){this.item=t},updateUsersList:function(){var t=this;return Object(d["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.isUpdated=!1,e.next=3,t.GET_ALL_USERS();case 3:case"end":return e.stop()}}),e)})))()}}),mounted:function(){this.GET_ALL_USERS()}},K=H,z=Object(b["a"])(K,c,l,!1,null,"3ffd0e5f",null),Q=z.exports,W={name:"Users",components:{UsersList:Q,Navbar:r["a"]},computed:Object(n["a"])({},Object(o["c"])(["getToken"])),methods:Object(n["a"])({},Object(o["b"])(["AUTH_LOGOUT"])),mounted:function(){}},Z=W,tt=Object(b["a"])(Z,i,a,!1,null,"f33fa9a6",null);e["default"]=tt.exports}}]);
//# sourceMappingURL=chunk-56519938.465581b3.js.map