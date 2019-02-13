package gui

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxStyle
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane.SplitPaneStyle
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle
import com.badlogic.gdx.scenes.scene2d.ui.Tree.TreeStyle
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle

class FantasticPlasticSkin : Skin() {
    private val asm:AssetManager = AssetManager()
    private var defaultFont:BitmapFont? = null

    private val scroll: ScrollPaneStyle = ScrollPaneStyle()
    private val split:SplitPaneStyle = SplitPaneStyle()
    private val tree:TreeStyle = TreeStyle()
    private val label: LabelStyle = LabelStyle()
    private val button:ButtonStyle = ButtonStyle()
    private val tbutton:TextButtonStyle = TextButtonStyle()
    private val check:CheckBoxStyle = CheckBoxStyle()
    private val tfield:TextFieldStyle = TextFieldStyle()
    private val tarea:TextFieldStyle = TextFieldStyle()
    private val list:ListStyle = ListStyle()
    private val select:SelectBoxStyle = SelectBoxStyle()
    private val progress:ProgressBarStyle = ProgressBarStyle()
    private val slider:SliderStyle = SliderStyle()
    private val window:WindowStyle = WindowStyle()
    private val tpad:TouchpadStyle = TouchpadStyle()
    private val dialog:WindowStyle = WindowStyle()

    fun prepare(){
        asm.load("bmfonts/unifont/unifont-16.fnt", BitmapFont::class.java)
        asm.load("bmfonts/demo-china.fnt", BitmapFont::class.java)
        asm.finishLoading()

        addRegions(TextureAtlas(Gdx.files.internal("skin/uiskin.atlas"))) //default ligdx skin from github
        addRegions(TextureAtlas(Gdx.files.internal("skin/fap.atlas"))) //fantastic plastic skin atlas
        addRegions(TextureAtlas(Gdx.files.internal("skin/fap80.atlas"))) //fantastic plastic 80 skin atlas
        add("unifont-16", asm.get("bmfonts/unifont/unifont-16.fnt"), BitmapFont::class.java)
        add("demo-china-64", asm.get("bmfonts/demo-china.fnt"), BitmapFont::class.java)
        load(Gdx.files.internal("skin/uiskin.json")) //now unifont-16 font can be used
        defaultFont = get("demo-china-64" ,  BitmapFont::class.java) //prepared uses Hiero libgdx tool
//        defaultFont = get("unifont-16" ,  BitmapFont::class.java) //prepared uses Hiero libgdx tool
//        defaultFont = get("default-font" ,  BitmapFont::class.java) //font from default libgdx skin
        val fapnumber:String = "fap80" //change it enough that switch to fap/fap80 etc altas

        scroll.vScrollKnob = getDrawable(fapnumber+"-vscrollknob")
        scroll.vScroll = getDrawable(fapnumber+"-vscroll")
        scroll.hScrollKnob = getDrawable(fapnumber+"-hscrollknob")
        scroll.hScroll = getDrawable(fapnumber+"-hscroll")

        split.handle = getDrawable(fapnumber+"-splitpane")

        tree.minus = getDrawable(fapnumber+"-minus")
        tree.plus = getDrawable(fapnumber+"-plus")

        label.background = getDrawable(fapnumber+"-label-background")
        label.font = defaultFont

        button.up = getDrawable(fapnumber+"-button-up")
        button.down = getDrawable(fapnumber+"-button-down")

        tbutton.up = getDrawable(fapnumber+"-button-up")
        tbutton.down = getDrawable(fapnumber+"-button-down")
        tbutton.font = defaultFont

        check.checkboxOn = getDrawable(fapnumber+"-check-on")
        check.checkboxOff = getDrawable(fapnumber+"-check-off")
        check.font = defaultFont

        tfield.cursor = getDrawable(fapnumber+"-cursor")
        tfield.selection = getDrawable(fapnumber+"-cursor")
        tfield.background = getDrawable(fapnumber+"-textfield-background")
        tfield.disabledBackground = getDrawable(fapnumber+"-textfield-disabled")
        tfield.focusedBackground = getDrawable(fapnumber+"-textfield-focused")
        tfield.font = defaultFont
        tfield.fontColor = Color.WHITE

        tarea.cursor = getDrawable(fapnumber+"-cursor")
        tarea.selection = getDrawable(fapnumber+"-cursor")
        tarea.background = getDrawable(fapnumber+"-textfield-background")
        tarea.disabledBackground = getDrawable(fapnumber+"-textfield-disabled")
        tarea.focusedBackground = getDrawable(fapnumber+"-textfield-focused")
        tarea.font = defaultFont
        tarea.fontColor = Color.WHITE

        list.background = getDrawable(fapnumber+"-list-background")
        list.selection = getDrawable(fapnumber+"-list-selection")
        list.down = getDrawable(fapnumber+"-list-down")
        list.font = defaultFont

        select.listStyle = list
        select.scrollStyle = scroll
        select.background = getDrawable(fapnumber+"-selectbox-background")
        select.font = defaultFont

        progress.background = getDrawable(fapnumber+"-progressbar-background")
        progress.knob = getDrawable(fapnumber+"-progressbar-knob")
        progress.knobAfter = getDrawable(fapnumber+"-progressbar-knobafter")
        progress.knobBefore = getDrawable(fapnumber+"-progressbar-knobbefore")

        slider.knob = getDrawable(fapnumber+"-slider-knob")
        slider.background = getDrawable(fapnumber+"-slider-background")

        window.background = getDrawable(fapnumber+"-window-background")
        window.titleFont = defaultFont

        tpad.background = getDrawable(fapnumber+"-touchpad-background")
        tpad.knob = getDrawable(fapnumber+"-touchpad-knob")

        dialog.background = getDrawable(fapnumber+"-window-background")
        dialog.titleFont = defaultFont

        add("fap", scroll)
        add("fap", split)
        add("fap", tree)
        add("fap", label)
        add("fap", button)
        add("fap", tbutton)
        add("fap", check)
        add("fap", tfield)
        add("fap", tarea)
        add("fap", list)
        add("fap", select)
        add("fap", progress)
        add("fap", slider)
        add("fap", window)
        add("fap", tpad)
        add("fap", dialog)

        load(Gdx.files.internal("skin/uiskin.json")) //now new styles can be used
    }
}