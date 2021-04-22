// pages/ask/ask.js
const utils = require("../../utils/util")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    value:'',
    page: 1,
    ask_list:[
      {
        id: 1,
        name:"河边的CC啊",
        book:"平凡的世界",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        time:"2021-01-01",
        avatar:"https://tse1-mm.cn.bing.net/th/id/OET.b0835fdb04124319b21ff2c797de08db?w=272&h=272&c=7&rs=1&o=5&dpr=1.56&pid=1.9"
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
    if (typeof this.getTabBar === 'function' &&
    this.getTabBar()) {
    this.getTabBar().setData({
        active: 1
      })
    }
    let instance = this
    let promise = utils.get('http://www.booknet.com/app/search/asks/get/1')
    promise.then((value)=>{
      // console.log(value)
      instance.setData({ask_list: value.data.data})
    })
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
    let instance = this
    let promise = utils.get('http://www.booknet.com/app/search/asks/get/1')
    promise.then((value)=>{
      console.log(value)
      instance.setData({
        ask_list: value.data.data,
        page: 1
      })
      wx.stopPullDownRefresh({
        success: (res) => {},
      })
    })
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    let instance = this
    let num = instance.data.page + 1
    let promise = utils.get('http://www.booknet.com/app/search/asks/get/' + num)
    promise.then((value) => {
      if(value.data.code == 200){
        let list = instance.data.book_list.concat(value.data.data)
        instance.setData({
          ask_list: list,
          page: num
        })
      }
    })
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  // 搜索框查找监听事件
  onSearch: function(event){
    console.log(event.detail);
    wx.navigateTo({
      url: '/pages/find/find?detail=' + event.detail,
    })
  },

  // 选中求书贴跳转事件
  selectAsk: function(event){
    let index = event.currentTarget.dataset.index;
    let ask_id = this.data.ask_list[index].id
    let ask_name = this.data.ask_list[index].name
    let ask_avatar = this.data.ask_list[index].avatar
    wx.navigateTo({
      url: '/pages/content/content?index='+ask_id + '&name=' + ask_name + '&avatar=' + ask_avatar
    })
  }
})

/**
 *     ask_list:[
      {
        user:"河边的CC啊",
        book:"平凡的世界",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        time:"2021-01-01",
        avatarUrl:"https://tse1-mm.cn.bing.net/th/id/OET.b0835fdb04124319b21ff2c797de08db?w=272&h=272&c=7&rs=1&o=5&dpr=1.56&pid=1.9"
      },
      {
        user:"河边的CC啊",
        book:"活着",
        desc:"《活着》讲述一个人一生的故事，这是一个历尽世间沧桑和磨难老人的人生感言，是一幕演绎人生苦难经历的戏剧。",
        time:"2021-01-01",
        avatarUrl:"https://tse1-mm.cn.bing.net/th/id/OET.b0835fdb04124319b21ff2c797de08db?w=272&h=272&c=7&rs=1&o=5&dpr=1.56&pid=1.9"
      },
      {
        user:"Jesbru",
        book:"时间简史",
        desc:"《时间简史》是英国物理学家斯蒂芬·威廉·霍金创作的科普著作，首次出版于1988年。全书共十二章，讲述了关于宇宙本性的最前沿知识.",
        time:"2021-01-01",
        avatarUrl:"https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoaWS5nSxdN3X9rTMclPXYK3jgrGl2ae9PaibLXWpstXw7Siaia1BvZ5Ix2IibaDdyUkVOficyh2cZFPOw/132"
      },
      {
        user:"jesbru",
        book:"平凡的世界",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        time:"2021-01-01",
        avatarUrl:"https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoaWS5nSxdN3X9rTMclPXYK3jgrGl2ae9PaibLXWpstXw7Siaia1BvZ5Ix2IibaDdyUkVOficyh2cZFPOw/132"
      },
      {
        user:"河边的CC啊",
        book:"时间简史",
        desc:"《时间简史》是英国物理学家斯蒂芬·威廉·霍金创作的科普著作，首次出版于1988年。全书共十二章，讲述了关于宇宙本性的最前沿知识.",
        time:"2021-01-01",
        avatarUrl:"https://tse1-mm.cn.bing.net/th/id/OET.b0835fdb04124319b21ff2c797de08db?w=272&h=272&c=7&rs=1&o=5&dpr=1.56&pid=1.9"
      },
      {
        user:"jesbru",
        book:"活着",
        desc:"《活着》讲述一个人一生的故事，这是一个历尽世间沧桑和磨难老人的人生感言，是一幕演绎人生苦难经历的戏剧。",
        time:"2021-01-01",
        avatarUrl:"https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoaWS5nSxdN3X9rTMclPXYK3jgrGl2ae9PaibLXWpstXw7Siaia1BvZ5Ix2IibaDdyUkVOficyh2cZFPOw/132"
      },
    ]
 */