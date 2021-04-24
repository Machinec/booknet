// pages/search/search.js
const utils = require("../../utils/util")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    book_list:[
      {
        price:'5.00',
        desc:"《时间简史》是英国物理学家斯蒂芬·威廉·霍金创作的科普著作，首次出版于1988年。全书共十二章，讲述了关于宇宙本性的最前沿知识。", 
        book:"时间简史",
        image: 'https://bkimg.cdn.bcebos.com/pic/0bd162d9f2d3572c2b694f428d13632763d0c3a1?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U5Mg==,g_7,xp_5,yp_5/format,f_auto',
      },
      {
        price:"6.00",
        desc:"《时间简史》是英国物理学家斯蒂芬·威廉·霍金创作的科普著作，首次出版于1988年。全书共十二章，讲述了关于宇宙本性的最前沿知识。",
        book:"时间简史",
        image: 'https://bkimg.cdn.bcebos.com/pic/0bd162d9f2d3572c2b694f428d13632763d0c3a1?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U5Mg==,g_7,xp_5,yp_5/format,f_auto',
      },
    ],
    list_length: 0
  },

    // 选中书籍条目跳转事件
    selectBook: function(event){
      let index = event.currentTarget.dataset.index;
      let book_id = this.data.book_list[index].id
      wx.navigateTo({
        url: '/pages/book/book?index='+book_id,
      })
      // let index = event.currentTarget.dataset.index;
      // wx.navigateTo({
      //   url: '/pages/book/book?index='+index,
      // })
    },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log('首页参数 => ' + options.detail)
    let instance = this
    let promise = utils.get('http://www.booknet.com/app/search/find/book/' + options.detail)
    promise.then((value) => {
      if(value.data.code == 200){
        instance.setData({
          book_list: value.data.data,
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