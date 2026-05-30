
COMPATIBLE_MACHINE:gwcv4 = "gwcv4"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

DEPENDS += "lzop-native firmware-imx wireless-regdb"

unset KBUILD_DEFCONFIG

SRC_URI += " file://defconfig \
             file://0001-Add_engicam_dts.patch \
             file://microgea-mx6ull-gwcv4-dts1.dts \
             file://microgea-mx6ull-gwcv4-dts2.dts \
             file://gen_dts.sh"

do_compile:prepend() {
    cp ${UNPACKDIR}/*.dts ${S}/arch/arm/boot/dts/nxp/imx
}

kernel_do_configure:append() {
    echo "CONFIG_EXTRA_FIRMWARE_DIR=\"${WORKDIR}/recipe-sysroot/usr/lib/firmware/\"" >> ${B}/.config
}

# Generate the blob of all DTS for GWCv4 with the supplied shell script tool
# and then install that file to the deployment directory with images along other images
kernel_do_install:append() {
    cd arch/arm/boot/dts/nxp/imx
    chmod a+x ${UNPACKDIR}/gen_dts.sh
    ${UNPACKDIR}/gen_dts.sh
    mkdir -p ${DEPLOY_DIR_IMAGE}
    install -m 0644 gwcv4-dtbs.bin ${DEPLOY_DIR_IMAGE}
}


# Due to embedding MX firmware
INSANE_SKIP:kernel-dev += "buildpaths"
