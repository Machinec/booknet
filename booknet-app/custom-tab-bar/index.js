Component({
  data: {
    // selected: 0,
    // color: "#7A7E83",
    // selectedColor: "#3cc51f",
    // list: [{
    //   pagePath: "/index/index",
    //   iconPath: "/image/icon_component.png",
    //   selectedIconPath: "/image/icon_component_HL.png",
    //   text: "组件"
    // }, {
    //   pagePath: "/index/index2",
    //   iconPath: "/image/icon_API.png",
    //   selectedIconPath: "/image/icon_API_HL.png",
    //   text: "接口"
    // }]
    active: 0,
    list:[
      {
        "url" : "/pages/index/index",
        "icon" : "home-o",
        "text" : "首页"
      },
      {
        "url" : "/pages/release/release",
        "icon" : "add-o",
        "text" : "发布"
      },
      {
        "url" : "/pages/message/message",
        "icon" : "chat-o",
        "text" : "消息"
      },
      {
        "url" : "/pages/mine/mine",
        "icon" : "user-o",
        "text" : "我的"
      }
    ]
  },
  attached() {
  },
  methods: {
    // switchTab(e) {
    //   const data = e.currentTarget.dataset
    //   const url = data.path
    //   wx.switchTab({url})
    //   this.setData({
    //     selected: data.index
    //   })
    // },
    onChange(event){
      const active_id = event.detail
      const target_url = this.data.list[active_id].url
      wx.switchTab({
        url: target_url,
        success: (res) => {
          this.setData({active:active_id})
        },
        fail: (res) => {},
        complete: (res) => {},
      })
    }
  }
})