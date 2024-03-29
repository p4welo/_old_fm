(function (n, p, u) {
    var w = n([]), s = n.resize = n.extend(n.resize, {}), o, l = "setTimeout", m = "resize", t = m + "-special-event", v = "delay", r = "throttleWindow";
    s[v] = 250;
    s[r] = true;
    n.event.special[m] = {setup:function () {
        if (!s[r] && this[l]) {
            return false
        }
        var a = n(this);
        w = w.add(a);
        n.data(this, t, {w:a.width(), h:a.height()});
        if (w.length === 1) {
            q()
        }
    }, teardown:function () {
        if (!s[r] && this[l]) {
            return false
        }
        var a = n(this);
        w = w.not(a);
        a.removeData(t);
        if (!w.length) {
            clearTimeout(o)
        }
    }, add:function (b) {
        if (!s[r] && this[l]) {
            return false
        }
        var c;

        function a(d, h, g) {
            var f = n(this), e = n.data(this, t);
            e.w = h !== u ? h : f.width();
            e.h = g !== u ? g : f.height();
            c.apply(this, arguments)
        }

        if (n.isFunction(b)) {
            c = b;
            return a
        } else {
            c = b.handler;
            b.handler = a
        }
    }};
    function q() {
        o = p[l](function () {
            w.each(function () {
                var d = n(this), a = d.width(), b = d.height(), c = n.data(this, t);
                if (a !== c.w || b !== c.h) {
                    d.trigger(m, [c.w = a, c.h = b])
                }
            });
            q()
        }, s[v])
    }
})(jQuery, this);
(function (b) {
    var a = {};

    function c(f) {
        function e() {
            var h = f.getPlaceholder();
            if (h.width() == 0 || h.height() == 0) {
                return
            }
            f.resize();
            f.setupGrid();
            f.draw()
        }

        function g(i, h) {
            i.getPlaceholder().resize(e)
        }

        function d(i, h) {
            i.getPlaceholder().unbind("resize", e)
        }

        f.hooks.bindEvents.push(g);
        f.hooks.shutdown.push(d)
    }

    b.plot.plugins.push({init:c, options:a, name:"resize", version:"1.0"})
})(jQuery);