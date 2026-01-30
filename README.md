</p>
<h2 align="center">
  PigKing 技术论坛系统
</h2>
<p align="center">

</p>
<h4 align="center">
开源、精美、便捷的「数据可视化」低代码开发平台
</h4>
<h4 align="center">
<img src="https://gitee.com/dromara/go-view/badge/star.svg?theme=gvp" style="position: relative; display: inline-block; top: 6px; border-radius: 0px;" />
<img src="https://gitcode.com/GoView/go-view/star/badge.svg" style="display: inline-block; position: relative; top: 4px;">
</h4>

#### 项目介绍

<div>
  本系统为Pig People学习专用，账户发行权归Pig king（联系方式见下文）所有，曾为通过阿里云服务器 ECS(CentOS 系统 )布署上去的 web 项目，
  现为广大编程爱好者的技术资源社区，属于开源免费资源并持续更新，目的是不断提升Pig Pepole的能力，学习前沿技术。
  欢迎各位成为Pig People中的一员。
</div>

<h4>一、安装教程</h4>
1、远程仓库<br>
（1）查看当前仓库:git remote -v <br>
（2）添加仓库: git remote add gitee https://gitee.com/t-ctsj/ctsj-community.git <br>
（3）删除仓库: git remote remove origin <br>
（4）提交过程指令: <br>
    ❶添加变更：git add . <br>
    ❷提交代码：git commit -m "update: 小改介绍"） <br>
    ❸推送GitHub：git push origin main  <br>
    ❹推送Gitee： git push gitee main  <br>
    ❺提交冲突问题正在完善中...  <br>


#### 😶 **纯前端** 分支： **`master`**

#### 👻 携带 **后端** 请求分支: **`master`**

#### 📚 PigKing-Foot **文档** 地址：[https://www.mtruning.club/](https://www.mtruning.club/)

项目纯前端-Demo 地址：[https://vue.mtruning.club/](https://vue.mtruning.club/)

项目带后端-Demo 地址：[https://demo.mtruning.club/](https://demo.mtruning.club/)


#### 🤯 后端介绍

- ctsj-main: 类似于layout，主要是对系统的框架进行搭建，负责整体功能布局。
- ctsj-eureka: 注册服务中心
- ctsj-gateway: 路由服务与拦截
- ctsj-ai: AI Agent的部署（正在开发），现在为API的调用
- ctsj-login: 登录服务，独特的安全机制，并发的拦截。
- ctsj-admin: 管理系统，权限、角色、信息的综合控制
- ctsj-amuse: 多服务接口，引入外来服务

#### 前端介绍

- 框架：基于 `Vue3` 框架编写，使用 `hooks` 写法抽离部分逻辑，使代码结构更加清晰；

- 类型：使用 `TypeScript` 进行类型约束，减少未知错误发生概率，可以大胆修改逻辑内容；

- 性能：多处性能优化，使用页面懒加载、组件动态注册、数据滚动加载等方式，提升页面渲染速度；

- 存储：拥有本地记忆，部分配置项采用 `storage` 存储本地，提升使用体验；

- 封装：项目进行了详细的工具类封装如：路由、存储、加/解密、文件处理、主题、NaiveUI 全局方法、组件等

- 可视化：基于开源图表库[ECharts](https://echarts.apache.org/zh/index.html) 和 [VChart](https://www.visactor.io/vchart) 编写，具有丰富的图表类型和适配大屏的主题效果；

- 入选 NaiveUI 社区精选资源推荐：[查看 NaiveUI 推荐列表](https://www.naiveui.com/zh-CN/light/docs/community)

说明文档：正在制作中...

工作台：见上线

请求配置：参考vue3

数据过滤：


主要技术栈为：

| 名称           | 版本    | 名称        | 版本   |
|--------------|-------| --------- | ------ |
| Java         | 3.2.x | TypeScript4 | 4.6.x  |
| Python       | 4.2.x | NaiveUI   | 2.34.x |
| Vue系列        | 5.3.x | Pinia     | 2.0.x  |
| Spring系列     | 6.3.x | 🥰        | 🤗     |
| Copilot Ai   | 6.3.x    | 🥰        | 🤗     |



开发环境:

| 名称 | 版本    | 名称    | 版本   |
| ---- | ------- | ------- | ------ |
| node | 18.20.x | npm     | 10.7.x |
| pnpm | 8.6.7   | windows | 11     |

已完成图表：

| 分类   | 名称             | 名称       | 名称           | 名称                     |
| ------ | ---------------- | ---------- | -------------- | ------------------------ |
| 图表   | 柱状图           | 横向柱状图 | 折线图         | 单/多 折线面积图(渐变色) |
| \*     | 饼图             | 环形图     | 水球图         | 雷达图                   |
| \*     | NaiveUI 多种进度 | 散点图     | 对数回归散点图 | 热力图                   |
| \*     | 漏斗图           | 中国地图   | 高德地图       | 🦊                       |
| 信息   | 文字             | 渐变文字   | 词云           | 嵌套网页                 |
| \*     | 图片             | 视频       | 😺             | 🐯                       |
| 列表   | 滚动排名列表     | 滚动表格   | 🐮             | 🐐                       |
| 小组件 | 边框-01~13       | 装饰-01~05 | 数字翻牌       | 通用时间                 |
| \*     | 数字计数         | 倒计时     | 时钟           | 🦁                       |

## 浏览器支持

开发和测试平台均在 `Google` 和最新版 `EDGE` 上完成，暂未测试 `IE11` 等其它浏览器，如有需求请自行测试与兼容。

## 安装

请查看文档：正在开发

## 代码提交

- feat: 新功能
- fix: 修复 Bug
- docs: 文档修改
- perf: 性能优化
- revert: 版本回退
- ci: CICD 集成相关
- test: 添加测试代码
- refactor: 代码重构
- build: 影响项目构建或依赖修改
- style: 不影响程序逻辑的代码修改
- chore: 不属于以上类型的其他类型(日常事务)

## 交流群

QQ 群：596495975

版权问题请联系：2292619425@qq.com

备注：侵权必究，PigKing People 将维护到底！！！

## PigKing Pro 部分功能展示

体验地址： <a href="" target="_blank">正在开发中...</a>

