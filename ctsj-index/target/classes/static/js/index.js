function show() {

  $.ajax({
    url: '../cart?op=find',
    type: 'get',
    dataType: "json",
    success: function (rs) {
      if (rs.code == 200) {
        let mcd = rs.data
        if (mcd.length > 0) {
          mcd.forEach(function (dom) {
            $('.main-con-container').append(`<div class="container-box">
            <input type="checkbox" class="radio">
            <i><img src="${dom.pic}g" alt=""></i>
            <p>${dom.name}</p>
            <span>￥${dom.price}.00</span>
            <div class="add">
                <div class="add-boxs4 "></div>
                <strong class="reduce-five">一</strong>
                <i class="num-five number">${dom.quantity}</i>
                <strong class="adds-five">＋</strong>
            </div>
            <h5 class="money-five nowmoney">￥${dom.price}</h5>
            <a href="#" class="btn" title="删除" onclick="deleteGood(dom.name)" >X</a>
        </div>`)
          })
          // dal()
          updateCheckboxes()
          var elementsByClassName = document.getElementsByClassName('reduce-five');
          Autoplayadd(document.querySelectorAll('.reduce-five'), document.querySelectorAll('.num-five'), document.querySelectorAll('.adds-five'), document.querySelectorAll('.money-five'), document.querySelectorAll('.add-boxs4'));
          Getmoney()

        };
      }
    }
  })
}



function Move(a, b) {
  a.on('mouseenter', function () {
    b.stop().fadeIn()
  })
  a.on('mouseleave', function () {
    b.stop().fadeOut()
  })
} // 封装移入移出函数
Move($('.connect'), $('.fixed-right-img'))
Move($('.app'), $('.fixed-right-img1'))
Move($('.newman'), $('.fixed-right-img2'))
Move($('.focus'), $('.fixed-right-img3'))

// 浏览器滚动距离大于10 显示回到顶部按钮 点击回到顶部
$(window).on('scroll', function () {
  if ($(window).scrollTop() > 10) {
    $('.return-top').stop().slideDown('fast')
  } else {
    $('.return-top').stop().slideUp('fast')
  }
})
$('.return-top').on('click', function () {
  $('html').stop().animate({
    scrollTop: 0
  }, 200, 'linear')
})
Move($('.banner-left-one'), $('.banner-left-box'))
Move($('.banner-left-two'), $('.banner-left-box1'))
$('.focus1').on('click', function () {
  $('.fixed-right-img4').stop().fadeIn()
})
$('.focus1').on('mouseleave', function () {
  $('.fixed-right-img4').stop().fadeOut()
})
// 当滚动距离大于商品页高度结账栏由固定定位改成页面定位
$(window).on('scroll', function () {
  $('.bill').addClass('fixed-bill')
  if ($(window).scrollTop() > 150) {
    $('.bill').removeClass('fixed-bill')
  }
  else {
    $('.bill').addClass('fixed-bill')
  }
})
var all = document.querySelectorAll('.all-choose')
var radio = document.querySelectorAll('.radio')
let resnum = document.querySelector('.quantity')
let resmoney = document.querySelector('.results')
// 点击全选的时候 所有单选全部勾中
function updateCheckboxes() {
  var all = document.querySelectorAll('.all-choose')
  var radio = document.querySelectorAll('.radio')
  for (let i = 0; i < all.length; i++) {
    all[i].onclick = function () {
      for (i = 0; i < all.length; i++) {
        all[i].checked = this.checked
        if (all[i].checked == true) {
          gob.className = 'right'
        } else {
          gob.className = 'go-bill'
        }
      }
      for (i = 0; i < radio.length; i++) {
        radio[i].checked = this.checked
      }
      Getmoney()
    }
  }
  for (let i = 0; i < radio.length; i++) {
    radio[i].onclick = function () {
      var flag = true
      for (i = 0; i < radio.length; i++) {
        if (!radio[i].checked) {
          flag = false
        }
      }
      for (i = 0; i < all.length; i++) {
        all[i].checked = flag
      }
      if (this.checked) {
        gob.className = 'right'
      }
      if (radio[0].checked == false && radio[1].checked == false && radio[2].checked == false) {
        gob.className = 'go-bill'
      }
      Getmoney()
    }
  }
}
let gob = document.querySelector('.go-bill')
//遍历全选框只要有一个全选选中 下面结账就显示
// 点击加号 数量增加
// 封装一个函数添加数量和价格
// a 是减号 b是数量 c是加号 d是价格 e是盒子类名
function Autoplayadd(a, b, c, d, e) {
  for (var i = 0; i < a.length; i++) {
    (function (index) {
      let res = parseInt(b[index].innerHTML);
      let rmb = parseInt(d[index].innerHTML.replace('￥', ''));
      let rmb1 = rmb/res;
      a[index].addEventListener('click', function () {
        res = res - 1;
        if (res < 0) {
          res = 0;
        }
        b[index].innerHTML = res;
        d[index].innerHTML = '￥' + (res * rmb1).toFixed(2);
        if (res <= 0) {
          e[index].style.display = 'block';
        } else {
          e[index].style.display = 'none';
        }
        Getmoney();
      });
      c[index].onclick = function () {
        res = res + 1;
        b[index].innerHTML = res;
        d[index].innerHTML = '￥' + (res * rmb1).toFixed(2);
        e[index].style.display = 'none';
        Getmoney();
      };
    })(i);
  }
}


// 计算数量和价格
// 封装函数当选择框勾中的时候计算总金额
function Getmoney() {
  var radio = document.querySelectorAll('.radio')
  let nowmoneys = document.querySelectorAll('.nowmoney')
  let numbers = document.querySelectorAll('.number')
  let total = 0
  let mathres = 0
  for (let i = 0; i < radio.length; i++) {
    if (radio[i].checked) {
      let money = parseFloat(nowmoneys[i].innerHTML.replace('￥', ''))
      total += money
      math = parseInt(numbers[i].innerHTML)
      mathres += math
    }
  }
  document.querySelector('.results').innerHTML = '￥' + total.toFixed(2)
  document.querySelector('.quantity').innerHTML = mathres + '件'
}



let search = document.querySelector('.sear')
let i = 0
let sarr = ['电脑', '空调', '台灯', '日历', '蘑菇', '龙年']
setInterval(() => {
  search.placeholder = sarr[i]
  i++
  if (i == sarr.length) {
    i = 0
  }
}, 3000);
//发送Ajax请求 刷新页面
$('.again').click(()=>{
  show()
})
