# Permit root login
do_install_append () {
    sed -i 's/^#PermitRootLogin.*/PermitRootLogin yes/' ${D}${sysconfdir}/ssh/sshd_config
}
