# Remove recommendation for fonts since it is big and pulls also fontconfig
# NOTE: fswebcam will not be able to write banners (ie. time etc) anymore,
# but work otherwise (in case banner is requested, it will just disable it,
# but do the camera shot anyway))
RRECOMMENDS:${PN}:remove = "ttf-dejavu-sans"

# Alternative: use mono fonts which are ~half of the size used and the
# smallest of the ones available by default in Yocto
# NOTE: pass "--font DejaVuSansMono" to fswebcam to use it
# RRECOMMENDS:${PN} = "ttf-dejavu-sans-mono"
