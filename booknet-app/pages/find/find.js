// pages/find/find.js
const utils = require("../../utils/util")
Page({

  /**
   * 页面的初始数据
   */
  data: {

    ask_list:[
      {
        name:"河边的CC啊",
        book:"活着",
        desc:"《活着》讲述一个人一生的故事，这是一个历尽世间沧桑和磨难老人的人生感言，是一幕演绎人生苦难经历的戏剧。",
        time:"2021-01-01",
        avatar:"https://tse1-mm.cn.bing.net/th/id/OET.b0835fdb04124319b21ff2c797de08db?w=272&h=272&c=7&rs=1&o=5&dpr=1.56&pid=1.9"
      }
  
    ],
    list_length: 0
  },

    // 选中求书贴跳转事件
    selectAsk: function(event){
      // let index = event.currentTarget.dataset.index;
      // wx.navigateTo({
      //   url: '/pages/content/content?index='+index,
      // })

      let index = event.currentTarget.dataset.index;
      let ask_id = this.data.ask_list[index].id
      let ask_name = this.data.ask_list[index].name
      let ask_avatar = this.data.ask_list[index].avatar
      wx.navigateTo({
        url: '/pages/content/content?index='+ask_id + '&name=' + ask_name + '&avatar=' + ask_avatar
      })
    },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log('书贴搜索参数=> ' + options.detail)
    let instance = this
    let promise = utils.get('http://www.booknet.com/app/search/find/ask/' + options.detail)
    promise.then((value) => {
      if(value.data.code == 200){
        instance.setData({
          ask_list: value.data.data,
          list_length: value.data.data.length
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})