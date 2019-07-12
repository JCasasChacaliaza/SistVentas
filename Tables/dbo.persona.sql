CREATE TABLE [dbo].[persona]
(
[IDPER] [int] NOT NULL IDENTITY(1, 1),
[NOMPER] [varchar] (150) COLLATE Modern_Spanish_CI_AS NULL,
[APEPER] [varchar] (150) COLLATE Modern_Spanish_CI_AS NULL,
[SEXPER] [char] (1) COLLATE Modern_Spanish_CI_AS NULL,
[DNIPER] [char] (8) COLLATE Modern_Spanish_CI_AS NULL,
[TELPER] [char] (9) COLLATE Modern_Spanish_CI_AS NULL,
[ESTPER] [char] (1) COLLATE Modern_Spanish_CI_AS NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[persona] ADD CONSTRAINT [PK__persona__98FE8B7E41C57C15] PRIMARY KEY CLUSTERED  ([IDPER]) ON [PRIMARY]
GO
