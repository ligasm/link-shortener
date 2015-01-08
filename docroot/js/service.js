Liferay.Service.register("Liferay.Service.LinkShortener", "com.liferay.linkshortener.service", "link-shortener-portlet");

Liferay.Service.registerClass(
	Liferay.Service.LinkShortener, "Link",
	{
		addLink: true,
		deleteLink: true,
		getLink: true,
		getLinksByAutoGen: true,
		getLinksByShortLink: true,
		linkFactory: true,
		updateLink: true
	}
);