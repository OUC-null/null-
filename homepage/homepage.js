Page({
  data: {
    height:'',
    disabled:false,
    //res: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    re:[
      {
        imgPath: "/images/1.jpg",//头像路径
        name:"111",//联系人
        stuId:"17020030001",//发布人学号
        phone:"12345678901",//联系人电话
        stuffId:1,
        price:"22¥",//价格
        stuffImgPath: [
          "/images/1.jpg",
          "/images/3.jpg"
        ],//物品图片路径
        content:"123456"//描述
      },
      {
        imgPath: "/images/1.jpg",
        name: "111",
        stuId:"17020030002",
        phone:"12345678902",
        price: "23¥",
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
        price: "24¥",
        stuffId: 3,
        stuffImgPath: [
          "/images/1.jpg",
          "/images/1.jpg"
        ],//物品图片路径
        content: "12345678"
      }
    ]
  },

  lower() {
    var result = this.data.res;

    var resArr = [];
    for (let i = 0; i < 10; i++) {
      resArr.push(i);
    };
    var cont = result.concat(resArr);
    console.log(resArr.length);
    if (cont.length >= 100) {
      wx.showToast({ //如果全部加载完成了也弹一个框
        title: '我也是有底线的',
        icon: 'success',
        duration: 3000
      });
      return false;
    } else {
      wx.showLoading({ //期间为了显示效果可以添加一个过度的弹出框提示“加载中”  
        title: '加载中',
        icon: 'loading',
      });
      setTimeout(() => {
        this.setData({
          res: cont
        });
        wx.hideLoading();
      },1500)
    }
  },

  formSubmit:function(e){
    var key=e.detail.value.keyword;
    //显示搜索中的提示
    wx.showLoading({
      title: '搜索中...',
      icon:'loading'
    })
    //向搜索后端服务器发起请求
    wx.request({

      //URL
      url: 'http://localhost:8080/../..?keyword=' + key,

      //发送的数据
      data: key,

      //请求的数据时JSON格式
      header: {
        'Content-Type': 'application/json'
      },

      //请求成功
      success: function (res) {

        //控制台打印（开发调试用）
        console.log(res.data)

        //把所有结果存进一个名为re的数组
        that.setData({
          re: res.data,
        })

        //搜索成功后，隐藏搜索中的提示
        wx.hideLoading();
      }
    })
  },
  /**
     * 生命周期函数--监听页面加载
     */
  onLoad: function (options) {
    wx.getSystemInfo({
      success: (res) => {
        this.setData({
          height: res.windowHeight
        })
      }
    })
  },

  onShow: function () {
    if (this.data.keyword == '') {
      this.setData({ disabled: true });
    } else {
      this.setData({ disabled: false });
    }
  },
})

//index.js
//获取应用实例
/*
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function () {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
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
*/