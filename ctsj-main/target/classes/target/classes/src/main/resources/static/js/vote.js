document.write(`<script src="/login/js/login.js"></script>`);

// vue 组件 与 vue 对象的语法基本一致
Vue.component("vote",{
    template:`
<div>
    <div id="header" class="wrap">
        <img src="images/logo.gif" />
    </div>
    <div id="navbar" class="wrap">
        <div class="profile">
            <login>
                <template v-slot:nologin></template>
                <template v-slot:logined="a">
                    您好，{{a.m.uname}}
                    <a href="myinfo.html">个人主页</a>
                    <a href="logout?toPage=/index.html">退出</a>
                </template>
            </login>
            <span class="return"><a href="index.html">返回列表</a></span>
            <span class="addnew"><a href="add.html">添加新投票</a></span>
        </div>
        <div class="search">
            <form method="post" action="#">
                <input type="text" v-model="keywords" class="input-text" value=""/>
                <input @click.prevent="doFind" type="submit" name="submit" class="input-button" value="" />
            </form>
        </div>
    </div>
    <slot>默认插槽内容</slot>
    <div id="footer" class="wrap">
        伟哥信息 &copy; 版权所有
    </div>
</div>
    `,
    // vue 组件内部的 data 推荐使用函数语法
    data(){
        return {
            keywords : ""
        }
    }
    // $emit 发布自定义事件
    ,created(){
        //console.info(this.$listeners)
        axios.get("/myInfo").then(res=>{
            if(res.data.code==1){
                this.myinfo=res.data.data;
            }else {
                this.myinfo=null;
            }
        })
        if(location.search=="?tologin"){
            setTimeout(()=>{
                this.$alert("伟哥提示您：请先登录系统！！！");
            },100)
        }
    },
    methods:{
        doFind(){
            if(this.$listeners.find){
                // 如果有 find 监听器, 则触发事件
                this.$emit('find', this.keywords);
            } else {
                localStorage.setItem("keywords", this.keywords);
                location.href = "/index.html";
            }
        }
    }
})