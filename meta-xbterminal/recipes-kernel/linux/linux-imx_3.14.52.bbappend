PREMIRRORS += "git://git.freescale.com/imx/linux-2.6-imx.git git://repo.xbthq.co.uk/mirrors/linux-2.6-imx.git \n"

FILESEXTRAPATHS_append := ":${THISDIR}/linux-imx"

# Apply custom patch from ITL
SRC_URI_append_imx6ulevk-itl = "\
    file://0001_itl_apm_kernel.patch \
    file://0002_itl_apm_kernel.patch"

do_configure_prepend_imx6ulevk-itl() {
    cp ${S}/arch/arm/configs/imx_v7_defconfig ${WORKDIR}/defconfig
}
