// pages/history/history.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    active_tab: 0,   //标签也下标
    book_list:[
      {
        price:2.00,
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。1986年12月首次...",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      }
    ],
    ask_list:[
      {
        user:"河边的CC啊",
        book:"平凡的世界",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        time:"2021-01-01",
        read:"2021",
        avatarUrl:"https://tse1-mm.cn.bing.net/th/id/OET.b0835fdb04124319b21ff2c797de08db?w=272&h=272&c=7&rs=1&o=5&dpr=1.56&pid=1.9"
      },
      {
        user:"河边的CC啊",
        book:"平凡的世界",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版出版...",
        time:"2021-01-01",
        read:"2021",
        avatarUrl:"https://tse1-mm.cn.bing.net/th/id/OET.b0835fdb04124319b21ff2c797de08db?w=272&h=272&c=7&rs=1&o=5&dpr=1.56&pid=1.9"
      },
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
    wx.showToast({
      title: `切换到标签 ${event.detail.name}`,
      icon: 'none',
    });
    let str ="《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版出版..."
    console.log(str.length)
  }
})