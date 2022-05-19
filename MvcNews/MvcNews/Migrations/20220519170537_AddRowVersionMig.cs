using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace MvcNews.Migrations
{
    public partial class AddRowVersionMig : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<string>(
                name: "Text",
                table: "News",
                type: "nvarchar(140)",
                maxLength: 140,
                nullable: false,
                defaultValue: "",
                oldClrType: typeof(string),
                oldType: "nvarchar(max)",
                oldNullable: true);

            migrationBuilder.AddColumn<byte[]>(
                name: "RowVersion",
                table: "News",
                type: "rowversion",
                rowVersion: true,
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "RowVersion",
                table: "News");

            migrationBuilder.AlterColumn<string>(
                name: "Text",
                table: "News",
                type: "nvarchar(max)",
                nullable: true,
                oldClrType: typeof(string),
                oldType: "nvarchar(140)",
                oldMaxLength: 140);
        }
    }
}
