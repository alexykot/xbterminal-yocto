FILESEXTRAPATHS_append := ":${THISDIR}/files"

# Fix screen issue for wandboard
SRC_URI_append_wandboard = " file://fix_config_wandboard_mmcargs.patch "

# Apply custom patch from ITL
SRC_URI_append_imx6ulevk-itl = "\
    file://0001_itl_apm_u-boot.patch \
    file://0002_itl_apm_u-boot.patch \
    file://0003_itl_apm_u-boot.patch"
