HOMEPAGE = "http://saltstack.com/"
SECTION = "admin"
LICENSE = "Apache-2.0"
DEPENDS = "\
           python-msgpack \
           python-pyyaml \
           python-jinja2 \
           python-markupsafe \
           python-pyzmq \
           python-pycrypto \
           python-m2crypto \
"


S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools update-rc.d systemd allarch

PACKAGES += "\
           ${PN}-api \
           ${PN}-cloud \
           ${PN}-common \
           ${PN}-master \
           ${PN}-minion \
           ${PN}-ssh \
           ${PN}-syndic \
           ${PN}-bash-completion \
"

SYSTEMD_PACKAGES = "${PN}-minion"

do_install_append() {
        install -d ${D}${sysconfdir}/bash_completion.d/
        install -m 0644 ${WORKDIR}/${PN}-${PV}/pkg/salt.bash ${D}${sysconfdir}/bash_completion.d/${PN}-common
        install -d ${D}${sysconfdir}/logrotate.d/
        install -m 0644 ${WORKDIR}/${PN}-${PV}/pkg/rpm/logrotate.salt ${D}${sysconfdir}/logrotate.d/${PN}-common
        install -d ${D}${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/${PN}-${PV}/pkg/rpm/salt-minion ${D}${sysconfdir}/init.d/${PN}-minion
        install -m 0755 ${WORKDIR}/${PN}-${PV}/pkg/rpm/salt-api ${D}${sysconfdir}/init.d/${PN}-api
        install -m 0755 ${WORKDIR}/${PN}-${PV}/pkg/rpm/salt-master ${D}${sysconfdir}/init.d/${PN}-master
        install -m 0755 ${WORKDIR}/${PN}-${PV}/pkg/rpm/salt-syndic ${D}${sysconfdir}/init.d/${PN}-syndic
        install -d ${D}${sysconfdir}/${PN}/
        install -m 0644 ${WORKDIR}/${PN}-${PV}/conf/minion ${D}${sysconfdir}/${PN}/minion
        install -m 0644 ${WORKDIR}/${PN}-${PV}/conf/master ${D}${sysconfdir}/${PN}/master
        install -m 0644 ${WORKDIR}/${PN}-${PV}/conf/cloud ${D}${sysconfdir}/${PN}/cloud
        install -m 0644 ${WORKDIR}/${PN}-${PV}/conf/roster ${D}${sysconfdir}/${PN}/roster
        install -d ${D}${sysconfdir}/${PN}/cloud.conf.d ${D}${sysconfdir}/${PN}/cloud.profiles.d ${D}${sysconfdir}/${PN}/cloud.providers.d
        install -d ${D}${systemd_unitdir}/system/
        install -m 0644 ${WORKDIR}/${PN}-${PV}/pkg/${PN}-minion.service  ${D}${systemd_unitdir}/system/${PN}-minion.service

        install -d ${D}${sysconfdir}/${PN}/minion.d/
        install -m 0644 ${WORKDIR}/master.conf ${D}${sysconfdir}/${PN}/minion.d/master.conf
        install -m 0644 ${WORKDIR}/grains.conf ${D}${sysconfdir}/${PN}/minion.d/grains.conf
        install -m 0644 ${WORKDIR}/modules.conf ${D}${sysconfdir}/${PN}/minion.d/modules.conf
        echo "  machine: ${MACHINE}" >> ${D}${sysconfdir}/${PN}/minion.d/grains.conf
}

ALLOW_EMPTY_${PN} = "1"
FILES_${PN} = ""

INITSCRIPT_PACKAGES = "${PN}-minion ${PN}-api ${PN}-master ${PN}-syndic"

DESCRIPTION_COMMON = "salt is a powerful remote execution manager that can be used to administer servers in a\
 fast and efficient way. It allows commands to be executed across large groups of servers. This means systems\
 can be easily managed, but data can also be easily gathered. Quick introspection into running systems becomes\
 a reality. Remote execution is usually used to set up a certain state on a remote system. Salt addresses this\
 problem as well, the salt state system uses salt state files to define the state a server needs to be in. \
Between the remote execution system, and state management Salt addresses the backbone of cloud and data center\
 management."

SUMMARY_${PN}-minion = "client package for salt, the distributed remote execution system"
DESCRIPTION_${PN}-minion = "${DESCRIPTION_COMMON} This particular package provides the worker agent for salt."
RDEPENDS_${PN}-minion = "python ${PN}-common (= ${EXTENDPKGV}) python-m2crypto python-pycrypto python-msgpack python-pyzmq (>= 13.1.0) procps python-apt"
RRECOMMENDS_${PN}-minion_append_x64 = "dmidecode"
RSUGGESTS_${PN}-minion = "python-augeas"
CONFFILES_${PN}-minion = "${sysconfdir}/${PN}/minion ${sysconfdir}/init.d/${PN}-minion ${sysconfdir}/minion.d/grains.conf ${sysconfdir}/minion.d/grains.conf ${sysconfdir}/minion.d/modules.conf"
FILES_${PN}-minion = "${bindir}/${PN}-minion ${sysconfdir}/${PN}/minion.d/ ${CONFFILES_${PN}-minion} ${systemd_unitdir}/system/${PN}-minion.service"
RPROVIDES_${PN}-minon += "${PN}-minon-systemd"
RREPLACES_${PN}-minion += "${PN}-minion-systemd"
RCONFLICTS_${PN}-minion += "${PN}-minion-systemd"
SYSTEMD_SERVICE_${PN}-minion = "${PN}-minion.service"

SUMMARY_${PN}-common = "shared libraries that salt requires for all packages"
DESCRIPTION_${PN}-common ="${DESCRIPTION_COMMON} This particular package provides shared libraries that \
salt-master, salt-minion, and salt-syndic require to function."
RDEPENDS_${PN}-common = "python python-jinja2 python-pyyaml"
RRECOMMENDS_${PN}-common = "lsb"
RSUGGESTS_${PN}-common = "python-mako python-git"
RCONFLICTS_${PN}-common = "python-mako (< 0.7.0)"
CONFFILES_${PN}-common="${sysconfdir}/logrotate.d/${PN}-common"
FILES_${PN}-common = "${bindir}/${PN}-call ${libdir}/python2.7/ ${CONFFILES_${PN}-common}"

SUMMARY_${PN}-ssh = "remote manager to administer servers via salt"
DESCRIPTION_${PN}-ssh = "${DESCRIPTION_COMMON} This particular package provides the salt ssh controller. It \
is able to run salt modules and states on remote hosts via ssh. No minion or other salt specific software needs\
 to be installed on the remote host."
RDEPENDS_${PN}-ssh = "python ${PN}-common (= ${EXTENDPKGV}) python-msgpack"
CONFFILES_${PN}-ssh="${sysconfdir}/${PN}/roster"
FILES_${PN}-ssh = "${bindir}/${PN}-ssh ${CONFFILES_${PN}-ssh}"

SUMMARY_${PN}-api = "generic, modular network access system"
DESCRIPTION_${PN}-api = "a modular interface on top of Salt that can provide a variety of entry points into a \
running Salt system. It can start and manage multiple interfaces allowing a REST API to coexist with XMLRPC or \
even a Websocket API. The Salt API system is used to expose the fundamental aspects of Salt control to external\
 sources. salt-api acts as the bridge between Salt itself and REST, Websockets, etc. Documentation is available\
 on Read the Docs: http://salt-api.readthedocs.org/"
RDEPENDS_${PN}-api = "python ${PN}-master"
RSUGGESTS_${PN}-api = "python-cherrypy"
CONFFILES_${PN}-api = "${sysconfdir}/init.d/${PN}-api"
FILES_${PN}-api = "${bindir}/${PN}-api ${CONFFILES_${PN}-api}"
INITSCRIPT_NAME_${PN}-api = "${PN}-api"
INITSCRIPT_PARAMS_${PN}-api = "defaults"

SUMMARY_${PN}-master = "remote manager to administer servers via salt"
DESCRIPTION_${PN}-master ="${DESCRIPTION_COMMON} This particular package provides the salt controller."
RDEPENDS_${PN}-master = "python ${PN}-common (= ${EXTENDPKGV}) python-m2crypto python-pycrypto python-msgpack python-pyzmq (>= 13.1.0)"
CONFFILES_${PN}-master="${sysconfdir}/init.d/${PN}-master  ${sysconfdir}/${PN}/master"
FILES_${PN}-master = "${bindir}/${PN} ${bindir}/${PN}-cp ${bindir}/${PN}-key ${bindir}/${PN}-master ${bindir}/${PN}-run ${bindir}/${PN}-unity ${CONFFILES_${PN}-master}"
INITSCRIPT_NAME_${PN}-master = "${PN}-master"
INITSCRIPT_PARAMS_${PN}-master = "defaults"

SUMMARY_${PN}-syndic = "master-of-masters for salt, the distributed remote execution system"
DESCRIPTION_${PN}-syndic = "${DESCRIPTION_COMMON} This particular package provides the master of masters for \
salt; it enables the management of multiple masters at a time."
RDEPENDS_${PN}-syndic = "python ${PN}-master (= ${EXTENDPKGV})"
CONFFILES_${PN}-syndic="${sysconfdir}/init.d/${PN}-syndic"
FILES_${PN}-syndic = "${bindir}/${PN}-syndic ${CONFFILES_${PN}-syndic}"
INITSCRIPT_NAME_${PN}-syndic = "${PN}-syndic"
INITSCRIPT_PARAMS_${PN}-syndic = "defaults"

SUMMARY_${PN}-cloud = "public cloud VM management system"
DESCRIPTION_${PN}-cloud = "provision virtual machines on various public clouds via a cleanly controlled profile and mapping system."
RDEPENDS_${PN}-cloud = "python ${PN}-common (= ${EXTENDPKGV}) python-msgpack python-requests"
RSUGGESTS_${PN}-cloud = "python-netaddr python-botocore"
CONFFILES_${PN}-cloud = "${sysconfdir}/${PN}/cloud"
FILES_${PN}-cloud = "${bindir}/${PN}-cloud ${sysconfdir}/${PN}/cloud.conf.d/ ${sysconfdir}/${PN}/cloud.profiles.d/ ${sysconfdir}/${PN}/cloud.providers.d/ ${CONFFILES_${PN}-cloud}"

FILES_${PN}-bash-completion = "${sysconfdir}/bash_completion.d/${PN}-common"
