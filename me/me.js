//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
   id:"17020031096",
   phone:"12345678901",
   info:"zfagbshtjydzsfbgnfjdt111111111111111111111111111111111111111"
  },

 relaunch:function(){
   wx.reLaunch({
     url: '/pages/homepage/homepage',
   })
 },

 myReleased:function(){
   wx.switchTab({
     url: '/pages/homepage/homepage',
   })
 },

  mySale: function () {
    wx.switchTab({
      url: '/pages/homepage/homepage',
    })
  },

  mBuyIn: function () {
    wx.switchTab({
      url: '/pages/homepage/homepage',
    })
  },

  bindPhone: function () {
    wx.switchTab({
      url: '/pages/homepage/homepage',
    })
  },

  //事件处理函数
  bindViewTap: function () {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })

  },
  getUserInfo: function (e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
