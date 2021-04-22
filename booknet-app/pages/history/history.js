// pages/history/history.js
const utils = require("../../utils/util")

Page({

  /**
   * 页面的初始数据
   */
  data: {
    active_tab: 0,   //标签也下标
    name: '河边的CC啊',
    avatar: 'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoaWS5nSxdN3X9rTMclPXYK3jgrGl2ae9PaibLXWpstXw7Siaia1BvZ5Ix2IibaDdyUkVOficyh2cZFPOw/132',
    book_list:[
      {
        price:2.00,
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。",
        book:"平凡的世界",
        image: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      }
    ],
    ask_list:[
      {
        name:"河边的CC啊",
        book:"平凡的世界",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        time:"2021-01-01",
        read:"2021",
        avatar:"https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132"
      },
    ],
    token: ''
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
    let url_book = 'http://www.booknet.com/app/user/book/list'
    let url_ask = 'http://www.booknet.com/app/user/ask/list'
    let data = {}
    let instance = this
    wx.getStorage({
      key: 'token',
      success: (res) =>{
        // token 消失
        if (res.data == '' || typeof res.data == 'undefined'){
          utils.login()
          return
        }
        instance.setData({token: res.data})
        let promise1 = utils.post(url_book, data, res.data)
        promise1.then((value) => {
          console.log(value)
          // 后台校验token失效
          if(value.data.code == 9527){
            utils.login()
            return
          }
          instance.setData({book_list: value.data.data})
        })

        let promise2 = utils.post(url_ask, data, res.data)
        promise2.then((value) => {
          console.log(value)
          if(value.data.code == 9527){
            utils.login()
            return
          }
          instance.setData({ask_list: value.data.data})
        })
      }
    })

    let app = getApp()
    this.setData({
      name: app.globalData.userInfo.nickName,
      avatar: app.globalData.userInfo.avatarUrl
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

  },

  tabOnChange: function(event){
    // wx.showToast({
    //   title: `切换到标签 ${event.detail.name}`,
    //   icon: 'none',
    // });
    // let str ="《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版出版..."
    console.log('切换标签')
  },

  bookDel: function(event){
    wx.showModal({
      content: '是否删除本条转让信息',
      success:(res)=>{
        if(res.confirm){
          let list_index = event.currentTarget.dataset.index
          let list = this.data.book_list
          let id = list[list_index].id
          let data = {id: id}
          let promise = utils.post('http://www.booknet.com/app/user/book/del', data, this.data.token)
          promise.then((value)=>{
            list.splice(list_index, 1);
            this.setData({book_list : list})
          })
        }
      }
    })
  },

  askDel: function(event){
    wx.showModal({
      content: '是否删除本条书贴',
      success:(res)=>{
        if(res.confirm){
          let list_index = event.currentTarget.dataset.index
          let list = this.data.ask_list
          let id = list[list_index].id
          let data = {id: id}
          let promise = utils.post('http://www.booknet.com/app/user/ask/del', data, this.data.token)
          promise.then((value) => {
            console.log(value)
            list.splice(list_index, 1);
            this.setData({ask_list: list})
          })
        }
      }
    })
  }
})