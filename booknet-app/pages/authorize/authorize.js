// pages/authorize/authorize.js
import Dialog from '../../lib/vant-weapp/dist/dialog/dialog'
Page({

  /**
   * 页面的初始数据
   */
  data: {

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

  login: function(){
    // 监听用户授权请求弹框选择
    wx.authorize({
      scope: 'scope.userInfo',
      success: (res) => {
        console.log("确认授权")
        console.log(res)
        wx.navigateBack({
          delta: 0,
        })
      },
      fail: (err) => {
        // console.log("拒绝授权")
        Dialog.alert({
          message: '书虫爬爬为校园内部交流平台，在进入之前我们获取您的授权确认身份，为此带来的不便请您体谅！',
        })
        // wx.showToast({
        //   title: '书虫爬爬为校园内部交流平台，在进入之前我们获取您的授权确认身份，为此带来的不便请您体谅！',
        //   icon: 'none',
        //   duration: 5000,
        //   mask: true
        // })
      }
    })
  }

})