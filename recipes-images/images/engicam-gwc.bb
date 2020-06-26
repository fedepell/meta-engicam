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
	iw \
	wpa-supplicant \
	opkg \
	opkg-collateral \
	json-c \
	ppp \
	ppp-tools \
	lua \
	luaposix \
	luacjson \
	luasys \
	luasocket \
	curl \
	libmodbus \
	firmware-imx-vpu-imx6q \
	openvpn \
	lighttpd \
	lighttpd-module-openssl \
	lighttpd-module-rewrite \
	lighttpd-module-redirect \
	ntp \
	procps \
	xz \
	wget \
	tar \
	sysstat \
	screen \
	msmtp \
	lsof \
	iptables \
	gzip \
	grep \
	bzip2 \
	bash \
	dos2unix \
	nano \
	traceroute \
	hostapd \
	iproute2-ss \
	iproute2-devlink \
	iproute2-genl \
	iproute2-ifstat \
	iproute2-lnstat \
	iproute2-nstat \
	iproute2-rtacct \
	iproute2-tc \
	iproute2-tipc \
	libxml2-utils \
	sqlite3 \
	util-linux \
	avahi-utils \
	usb-modeswitch \
	htop \
	dhcp-client \
	libmicrohttpd \
"

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



