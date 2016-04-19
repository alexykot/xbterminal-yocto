do_install_append() {
    sed -i '/PrivateNetwork=yes/ s/^/#/' ${D}${systemd_unitdir}/system/systemd-hostnamed.service
}
