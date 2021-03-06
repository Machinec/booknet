// pages/mine/mine.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: {
      name: 'CC啊',
      avatar: "https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoaWS5nSxdN3X9rTMclPXYK3jgrGl2ae9PaibLXWpstXw7Siaia1BvZ5Ix2IibaDdyUkVOficyh2cZFPOw/132"
    }
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
        active: 3
      })
    }
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

  }
})
