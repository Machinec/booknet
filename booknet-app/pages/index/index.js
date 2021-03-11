// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    value : '',
    book_list:[
      {
        price:2.00,
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      }
    ],
  },

  onShow: function(){
    // tabbar active设置
    if (typeof this.getTabBar === 'function' &&
    this.getTabBar()) {
    this.getTabBar().setData({
        active: 0
      })
    }
  },

  // 搜索框查找监听事件
  onSearch: function(event){
    console.log(event.detail);
  },
})
