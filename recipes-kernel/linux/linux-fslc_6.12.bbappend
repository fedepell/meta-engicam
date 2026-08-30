
COMPATIBLE_MACHINE:gwcv4 = "gwcv4"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

DEPENDS += "lzop-native firmware-imx wireless-regdb"

unset KBUILD_DEFCONFIG

SRC_URI += " file://defconfig \
             file://0001-Add_engicam_dts.patch \
             file://0002-Add_idscount.patch \
             file://microgea-mx6ull-gwcv4-dts1.dts \
             file://microgea-mx6ull-gwcv4-dts2.dts \
           "

do_compile:prepend() {
    cp ${UNPACKDIR}/*.dts ${S}/arch/arm/boot/dts/nxp/imx
}

kernel_do_configure:append() {
    echo "CONFIG_EXTRA_FIRMWARE_DIR=\"${WORKDIR}/recipe-sysroot/usr/lib/firmware/\"" >> ${B}/.config
}

# Due to embedding MX firmware
INSANE_SKIP:kernel-dev += "buildpaths"
