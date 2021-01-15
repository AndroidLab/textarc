# TextArc ![Download](https://api.bintray.com/packages/winged90/maven/textarc/images/download.svg?version=1.0.2)

Creating a simple arc text

# Preview

![textarc](./app/assets/photo/screenshot.jpg)

# How to use

In xml

```
<com.a_lab.textarc.TextArc
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            app:text="Text arc that was added to xml"
            app:radius="75dp"
            app:center_angle="-90"
            app:text_size="28sp"
            app:text_color="@color/red"
            app:font_family="@font/krabuler"/>
```

In code

```
TextArc textArc = new TextArc(this);
        textArc.setText("Text arc that was added programmatically");
        textArc.setRadius(255);
        textArc.setCenterAngle(-90);
        textArc.setTextColor(R.color.blue);
        textArc.setTextSize(72);
        textArc.setFontFamily(ResourcesCompat.getFont(this, R.font.krabuler));
```

# To get a Git project into your build:

```
dependencies {
	        implementation 'io.github.a.lab.develop:textarc:1.0.4'
	}
```
