// Peity jQuery plugin version 0.6.0
// (c) 2011 Ben Pickles
//
// http://benpickles.github.com/peity/
//
// Released under MIT license.
(function (i, k) {
    function o(a, h) {
        var b = k.createElement("canvas");
        b.setAttribute("width", a * m);
        b.setAttribute("height", h * m);
        m != 1 && b.setAttribute("style", "width:" + a + "px;height:" + h + "px");
        return b
    }

    var g = i.fn.peity = function (a, h) {
        k.createElement("canvas").getContext && this.each(function () {
            i(this).change(function () {
                var b = i.extend({}, h), d = this;
                i.each(b, function (a, c) {
                    i.isFunction(c) && (b[a] = c.call(d))
                });
                var f = i(this).html();
                g.graphers[a].call(this, i.extend({}, g.defaults[a], b));
                i(this).trigger("chart:changed", f)
            }).trigger("change")
        });
        return this
    };
    g.graphers = {};
    g.defaults = {};
    g.add = function (a, h, b) {
        g.graphers[a] = b;
        g.defaults[a] = h
    };
    var m = window.devicePixelRatio || 1;
    g.add("pie", {colours:["#FFF4DD", "#FF9900"], delimeter:"/", diameter:16}, function (a) {
        var h = i(this), b = h.text().split(a.delimeter), d = parseFloat(b[0]), f = parseFloat(b[1]), b = -Math.PI / 2, d = d / f * Math.PI * 2, f = o(a.diameter, a.diameter), e = f.getContext("2d"), c = f.width / 2;
        e.beginPath();
        e.moveTo(c, c);
        e.arc(c, c, c, d + b, d == 0 ? Math.PI * 2 : b, !1);
        e.fillStyle = a.colours[0];
        e.fill();
        e.beginPath();
        e.moveTo(c,
            c);
        e.arc(c, c, c, b, d + b, !1);
        e.fillStyle = a.colours[1];
        e.fill();
        h.wrapInner(i("<span>").hide()).append(f)
    });
    g.add("line", {colour:"#c6d9fd", strokeColour:"#4d89f9", strokeWidth:1, delimeter:",", height:16, max:null, min:0, width:32}, function (a) {
        var h = i(this), b = o(a.width, a.height), d = h.text().split(a.delimeter);
        d.length == 1 && d.push(d[0]);
        var f = Math.max.apply(Math, d.concat([a.max])), e = Math.min.apply(Math, d.concat([a.min])), c = b.getContext("2d"), g = b.width, l = b.height, q = g / (d.length - 1), f = l / (f - e), n = [], j;
        c.beginPath();
        c.moveTo(0,
            l + e * f);
        for (j = 0; j < d.length; j++) {
            var k = j * q, p = l - f * (d[j] - e);
            n.push({x:k, y:p});
            c.lineTo(k, p)
        }
        c.lineTo(g, l + e * f);
        c.fillStyle = a.colour;
        c.fill();
        if (a.strokeWidth) {
            c.beginPath();
            c.moveTo(0, n[0].y);
            for (j = 0; j < n.length; j++)c.lineTo(n[j].x, n[j].y);
            c.lineWidth = a.strokeWidth * m;
            c.strokeStyle = a.strokeColour;
            c.stroke()
        }
        h.wrapInner(i("<span>").hide()).append(b)
    });
    g.add("bar", {colour:"#4D89F9", delimeter:",", height:16, max:null, min:0, width:32}, function (a) {
        var h = i(this), b = h.text().split(a.delimeter), d = Math.max.apply(Math,
            b.concat([a.max])), f = Math.min.apply(Math, b.concat([a.min])), e = o(a.width, a.height), c = e.getContext("2d"), g = e.height, d = g / (d - f), l = m / 2, k = (e.width + l) / b.length;
        c.fillStyle = a.colour;
        for (a = 0; a < b.length; a++)c.fillRect(a * k, g - d * (b[a] - f), k - l, d * b[a]);
        h.wrapInner(i("<span>").hide()).append(e)
    })
})(jQuery, document);

