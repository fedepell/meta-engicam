DESCRIPTION = "GWC image based on Engicam hardware"

LICENSE = "MIT"

inherit core-image

EXTRA_IMAGE_FEATURES = " debug-tweaks ssh-server-openssh tools-debug package-management "


IMAGE_INSTALL_append = " \
	binutils \
	engicam-mtd-script \
	engicam-emmc-script \
	engicam-emmc-tools \
	iproute2 \
	canutils \
	cantest \
	mtd-utils \
	mtd-utils-ubifs \
	serialtools \
	devmem2 \
	i2c-tools \
	imx-kobs \
	u-boot-eng-fw-utils \
	minicom \
	ethtool \
	dosfstools \
	e2fsprogs \
	usbutils \
	cpufrequtils \
	iw \
	wpa-supplicant \
	opkg \
	opkg-collateral \
	json-c \
	ppp \
	lua \
	curl \
	libmodbus \
	firmware-imx-vpu-imx6q \
	openvpn \
	lighttpd \
	ntp \
"

#	lwb-bcm4343w-fw
#	bluez5
#	brcm-patchram-plus
#	obexftp
#	imx-test
#	wf111-driver

IMAGE_INSTALL_append_icoremx6 = " \
	firmware-imx-vpu-imx6q \
	imx-test \
	wf111-driver \
"

IMAGE_INSTALL_append_isiot = " \
	engicam-isiot-startup \
	lwb-bcm4343w-fw \
	bluez5 \
	brcm-patchram-plus \
	obexftp \
"

IMAGE_INSTALL_append_microdev = " \
	engicam-microdev-startup \
        lwb-bcm4343w-fw \
        bluez5 \
        brcm-patchram-plus \
        obexftp \
	hostapd \
	ppp \
"



