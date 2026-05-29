DESCRIPTION = "GWC image based on Engicam hardware"

LICENSE = "MIT"

inherit core-image

# TODO: REMOVE root/empty passwords once first rough testing is done
EXTRA_IMAGE_FEATURES = " ssh-server-openssh allow-empty-password allow-root-login empty-root-password "
# Note: packaging was removed since an A-B use makes it useless, can be readded: package-management

IMAGE_INSTALL:append = " \
	binutils \
	engicam-mtd-script \
	engicam-emmc-script \
	engicam-emmc-tools \
	gdbserver \
	strace \
	iproute2 \
	canutils \
	mtd-utils \
	mtd-utils-ubifs \
	devmem2 \
	i2c-tools \
	imx-kobs \
	minicom \
	ethtool \
	dosfstools \
	e2fsprogs \
	curl \
	procps \
	xz \
	wget \
	tar \
	sysstat \
	screen \
	lsof \
	iptables \
	gzip \
	grep \
	bzip2 \
	bash \
	dos2unix \
	nano \
	util-linux \
	avahi-utils \
	usb-modeswitch \
	htop \
	bind-utils \
	iputils \
	coreutils \
	usbutils \
	iw \
	wpa-supplicant \
	json-c \
	ppp \
	ppp-tools \
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
	libmodbus \
	libmicrohttpd \
	fswebcam \
	gd \
	chrony \
	chronyc \
	gpsd \
	libgps \
	openvpn \
	traceroute \
	netcat \
	dhcpcd \
	yasdi \
	libnodave \
	firmware-imx-vpu-imx6q \
	gnupg \
	kernel-module-rtl8733bu \
"
# TO BE READDED possibly:
#	opendnp3 // Dead and problems downloading :?
#	opkg     // TBD which packager
#	opkg-collateral
#	lua      // LUA and lighttpd probably built separately
#	luaposix
#	luacjson
#	luasys
#	luasocket
#	lighttpd
#	lighttpd-module-openssl
#	lighttpd-module-rewrite
#	lighttpd-module-redirect
#	lighttpd-module-alias
#	lighttpd-module-auth
#	lighttpd-module-authn-file
#	lighttpd-module-evasive
#	lighttpd-module-usertrack
#	lighttpd-module-setenv
#	lighttpd-module-cgi
#	lighttpd-module-compress
#	serialtools (do we need that??)
#	cantest (do we need that??)

# TOOLCHAIN_TARGET_TASK += " wpa-supplicant-staticdev libiec61850-staticdev lib60870-staticdev"

# This is necessary due to removal of some services in meta-engicam/recipes-core/systemd/systemd_%.bbappend
IMAGE_LOG_CHECK_EXCLUDES += "Failed to preset all unit: Unit .*[rpcbind.service|systemd-timesyncd.service] is masked"
