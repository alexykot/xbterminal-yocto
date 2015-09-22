FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI_append = "file://bluetooth"

inherit update-rc.d

INITSCRIPT_NAME = "bluetooth"
INITSCRIPT_PARAMS = "start 45 2 3 4 5 . stop 55 0 1 6 ."

do_install_append() {
  install -d ${D}${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/bluetooth ${D}${sysconfdir}/init.d/
}


inherit systemd

EXTRA_OECONF += "--with-systemdunitdir=${systemd_unitdir}/system/"

RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"
SYSTEMD_SERVICE_${PN} = "bluetooth.service"

SYSTEMD_AUTO_ENABLE = "enable"

