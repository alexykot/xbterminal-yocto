require ${BPN}.inc

PR = "${INC_PR}.2"

FILES_${PN} = "${servicedir}/xbterminal/xbterminal/main \
               ${servicedir}/xbterminal/xbterminal/runtime \
               ${servicedir}/xbterminal/xbterminal/gui/ts \
               ${systemd_unitdir}/system/${PN}.service \
               ${systemd_unitdir}/system/xbterminal-x.service \
              "

python populate_packages_prepend () {
    themes_dir = d.expand('${servicedir}/xbterminal/xbterminal/gui/themes/')
    theme_pn = d.expand('${PN}-theme-%s')
    do_split_packages(
        d,
        themes_dir,
        '^(.+)\.so$',
        theme_pn,
        'XBTerminal firmware - UI theme %s')
}

PACKAGES_DYNAMIC = "${PN}-theme-.*"
