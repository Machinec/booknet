// pages/content/content.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    content: {
      user:"河边的CC啊",
      book:"平凡的世界",
      desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。\n该书以中国70年代中期到80年代中期十年间为背景，通过复杂的矛盾纠葛，以孙少安和孙少平两兄弟为中心，刻画了当时社会各阶层众多普通人的形象；劳动与爱情、挫折与追求、痛苦与欢乐、日常生活与巨大社会冲突纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路。\n1991年3月，《平凡的世界》获中国第三届茅盾文学奖。\n2019年9月23日，该小说入选“新中国70年70部长篇小说典藏”。", 
      time:"2021-01-01",
      avatarUrl:"https://tse1-mm.cn.bing.net/th/id/OET.b0835fdb04124319b21ff2c797de08db?w=272&h=272&c=7&rs=1&o=5&dpr=1.56&pid=1.9",
      contact: "邮箱xxxxxxxx@163.com"
    },
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 获取从ask页面传来的参数
    console.log('content page ' + options.index)
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