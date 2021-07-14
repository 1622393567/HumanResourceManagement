$(function () {
    $("ul.accordion li span").on('click', function () {
        $(this).parent().siblings().removeClass('selected').find('div').hide();
        $(this).parent().addClass('selected');
        $(this).next().slideDown(500);
    });
});

/*
我们来分析一下。

　　首先，通过jQuery的选择器"ul.accordion li span"指定在菜单项的标题上点击，可以折叠菜单。

　　click事件处理函数的第一行代码做了两件事，一个是将其它菜单项的selected样式移除，另一个是将其它菜单项的div（包括其中的子菜单）隐藏起来。$(this).parent即span的上一级，即li。.siblings()查找它的兄弟元素，并使用链式调用首先移除其selected样式，再查找其中的div并隐藏。

　　第二行代码为当前点击菜单添加selected样式。

　　第三行代码展开当前菜单的子菜单。$(this).next()即span的下一个元素，即div（其中包含子菜单）。.slideDown(500)将子菜单向下缓缓展开，使用了CSS的动画效果，500指定动画时间为500毫秒。

 */