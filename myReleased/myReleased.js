Page({

  /**
   * 页面的初始数据
   */
  data: {
    height:'',
    width:'',
    res: [
      {
        imgPath: "/images/1.jpg",//头像路径
        name: "111",//联系人
        stuId: "17020030001",//发布人学号
        phone: "12345678901",//联系人电话
        stuffId: 1,
        price: "22",//价格
        stuffImgPath: [
          "/images/2.jpg",
          "/images/3.jpg"
        ],//物品图片路径
        content: "1234567890000000000001111111111111"//描述
      },
      {
        imgPath: "/images/1.jpg",
        name: "111",
        stuId: "17020030002",
        phone: "12345678902",
        price: "23",
        stuffId: 2,
        stuffImgPath: [
          "/images/1.jpg",
          "/images/1.jpg"
        ],
        content: "1234567"
      },
      {
        imgPath: "/images/1.jpg",
        name: "111",
        stuId: "17020030003",
        phone: "12345678903",
        price: "24",
        stuffId: 3,
        stuffImgPath: [
          "/images/1.jpg",
          "/images/1.jpg"
        ],//物品图片路径
        content: "12345678"
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