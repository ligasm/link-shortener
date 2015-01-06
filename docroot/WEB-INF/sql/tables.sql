create table LinkShortener_Link (
	uuid_ VARCHAR(75) null,
	linkId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	longLink VARCHAR(75) null,
	shortLink VARCHAR(75) null,
	active_ BOOLEAN,
	autoGen BOOLEAN
);