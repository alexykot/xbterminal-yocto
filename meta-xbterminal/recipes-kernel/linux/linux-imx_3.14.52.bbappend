FILESEXTRAPATHS_append := ":${THISDIR}/linux-imx"

# Apply custom patches from ITL
SRC_URI_imx6ulevk-itl = "\
    git://git.freescale.com/imx/linux-2.6-imx.git;branch=${SRCBRANCH} \
    file://0001_itl_apm_kernel.patch \
    file://0002_itl_apm_kernel.patch \
    file://0003_itl_apm_kernel.patch \
    file://0004_itl_apm_kernel.patch \
    file://0005_itl_apm_kernel.patch \
    file://0006_itl_apm_kernel.patch \
    file://0007_itl_apm_kernel.patch \
    "

do_configure_prepend_imx6ulevk-itl() {
    cp ${S}/arch/arm/configs/imx_v7_defconfig ${WORKDIR}/defconfig
}

MIRRORS_prepend = " git://git.freescale.com/imx/linux-2.6-imx.git git://repo.xbthq.co.uk/mirrors/linux-2.6-imx.git;protocol=http \n"
